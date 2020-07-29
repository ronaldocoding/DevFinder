package br.com.devfinder.controller;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

import br.com.devfinder.model.Desafio;
import br.com.devfinder.model.Desenvolvedor;
import br.com.devfinder.model.Empresa;
import br.com.devfinder.model.Endereco;
import br.com.devfinder.model.ids.DesafioId;
import br.com.devfinder.service.DesafioHabilidadeService;
import br.com.devfinder.service.DesafioService;
import br.com.devfinder.service.DesenvolvedorDesafioService;
import br.com.devfinder.service.EmpresaNotificacaoService;
import br.com.devfinder.service.EmpresaService;
import br.com.devfinder.service.SolucaoService;

/**
 * @author Ronaldo Costa
 *
 */
@Controller
public class EmpresaController {

	@Autowired
	private EmpresaService service;

	@Autowired
	private DesafioService serviceD;

	@Autowired
	private DesafioHabilidadeService serviceDH;

	@Autowired
	private DesenvolvedorDesafioService serviceSub;
	
	@Autowired
	private EmpresaNotificacaoService serviceN;
	
	@Autowired
	private SolucaoService serviceS;
		
	@RequestMapping(value = "/empDashboard", method = RequestMethod.GET)
	public String dashboard(Model model, HttpSession session) {
		model.addAttribute("perfil", session.getAttribute("perfil"));
		return "empDashboard";
	}
	
	@RequestMapping(value = "/empConfiguracoes", method = RequestMethod.GET)
	public String config(Model model, HttpSession session) {
		model.addAttribute("perfil", session.getAttribute("perfil"));
		return "empConfiguracoes";
	}
	
	@RequestMapping(value = "/empMeusDesafios", method = RequestMethod.GET)
	public String devMeusDesafios(Model model, HttpSession session) {
		Empresa emp = (Empresa) session.getAttribute("perfil");
		model.addAttribute("perfil", session.getAttribute("perfil"));
		model.addAttribute("desafios", serviceD.getDesafios(emp.getEmail()));
		model.addAttribute("service", serviceDH);
		return "empMeusDesafios";
	}
	

	
	@GetMapping("/formEmpresa")
	public String addForm(Model model) {
		model.addAttribute("empresa", new Empresa());
		model.addAttribute("endereco", new Endereco());
		
		return "formEmpresa";
	}
	
	@PostMapping("/addEmpresa")
	public String addEmpresa(@RequestParam("foto") MultipartFile foto,
			HttpServletRequest r, 
			Model model, 
			HttpSession session) {
		
		Endereco endereco = new Endereco(
				r.getParameter("estado"),
				r.getParameter("cidade"),
				r.getParameter("bairro"),
				r.getParameter("numero"),
				r.getParameter("rua"),
				r.getParameter("cep")
		);
		byte[] fotoByte=null;
		
		try {
			fotoByte = foto.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		Empresa empresa = new Empresa(
				r.getParameter("email"),
				fotoByte,
				r.getParameter("senha"),
				endereco,
				r.getParameter("site"),
				r.getParameter("telefone"),
				r.getParameter("apresentacao"),
				r.getParameter("nomeFantasia"),
				r.getParameter("razaoSocial"),
				r.getParameter("cnpj"),
				Integer.parseInt(r.getParameter("anoFundacao")),
				r.getParameter("ramoMercado"),
				Integer.parseInt(r.getParameter("totalDesenvolvedores")),
				r.getParameter("tipoVaga")
			);
				
		service.saveEmpresa(empresa);
		session.setAttribute("perfil", empresa);
		return "redirect:/empDashboard";
		
	}

	@PostMapping("/addEmpresas")
	public List<Empresa> addEmpresas(@RequestBody List<Empresa> empresas) {
		return service.saveEmpresas(empresas);
	}

	@GetMapping("/empresas")
	public List<Empresa> findAllEmpresas() {
		return service.getEmpresas();
	}

	@RequestMapping(value = "/imageEmp/{emp_id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("emp_id") String email) throws IOException {
    	Empresa emp = service.getEmpresaById(email);
    	
        byte[] imageContent = emp.getFoto();//get image from DAO based on id
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
    }
	@GetMapping("/empresaById/{email}")
	public String findEmpresaById(@PathVariable String email, Model model, HttpSession session) {
		model.addAttribute("empresa", service.getEmpresaById(email));
		model.addAttribute("desafios", serviceD.getDesafios(email));
		model.addAttribute("service", serviceDH);
		
		model.addAttribute("perfil", session.getAttribute("perfil"));
		
		model.addAttribute("serviceEmp", service);
		return "perfilEmpresa";
	}
	
    @GetMapping("/empresaByNomeFantasia/{nomeFantasia}")
	public Empresa findEmpresatByNomeFantasia(@PathVariable String nomeFantasia) {
		return service.getEmpresaByNomeFantasia(nomeFantasia);
	}

	@PutMapping("/updateEmpresa")
	public Empresa updateEmpresa(@RequestBody Empresa empresa) {
		return service.updateEmpresa(empresa);
	}
	
	@GetMapping("/deleteEmpresa")
	public String deleteEmpresa(Model model, HttpSession session) {
		Empresa emp = (Empresa) session.getAttribute("perfil");
		
		serviceN.deleteNotificacaoByEmpresa(emp.getEmail());
		serviceDH.deleteAllByEmpresa(emp.getEmail());
		serviceSub.deleteInscricaoByEmpresa(emp.getEmail());
		serviceN.deleteNotificacaoByEmpresa(emp.getEmail());
		serviceS.deleteSolucaoByEmpresa(emp.getEmail());
		serviceD.deleteDesafio(emp.getEmail());
		service.deleteEmpresa(emp.getEmail());
		return "redirect:/";
	}


}
