package br.com.devfinder.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.devfinder.model.Desenvolvedor;
import br.com.devfinder.model.DesenvolvedorAreaAtuacao;
import br.com.devfinder.model.DesenvolvedorHabilidade;
import br.com.devfinder.model.DesenvolvedorNotificacao;
import br.com.devfinder.model.Endereco;
import br.com.devfinder.model.Solucao;
import br.com.devfinder.service.DesafioHabilidadeService;
import br.com.devfinder.service.DesafioService;
import br.com.devfinder.service.DesenvolvedorAreaAtuacaoService;
import br.com.devfinder.service.DesenvolvedorDesafioService;
import br.com.devfinder.service.DesenvolvedorHabilidadeService;
import br.com.devfinder.service.DesenvolvedorNotificacaoService;
import br.com.devfinder.service.DesenvolvedorService;
import br.com.devfinder.service.SolucaoService;
import net.bytebuddy.matcher.ModifierMatcher.Mode;

/**
 * @author Ronaldo Costa
 *
 */
@Controller
public class DesenvolvedorController {

	@Autowired
	private DesenvolvedorService service;

	@Autowired
	private DesenvolvedorHabilidadeService serviceH;
	
	@Autowired
	private DesenvolvedorAreaAtuacaoService serviceA;
	
	@Autowired
	private DesafioService serviceD;	
	
	@Autowired
	private DesafioHabilidadeService serviceDH;
		
	@Autowired
	private DesenvolvedorDesafioService serviceSub;
	
	@Autowired
	private DesenvolvedorNotificacaoService serviceN;
	
	
	@Autowired
	private SolucaoService serviceS;
	
	@GetMapping("/formDev")
	public String addFormDev(Model model) {
		model.addAttribute("dev", new Desenvolvedor());
		model.addAttribute("endereco", new Endereco());
		return "formDesenvolvedor";
	}
	@PostMapping("/addDev")
	public String addDesenvolvedor(
			@RequestParam("area") ArrayList<String> areas,
			Model model, @RequestParam("habilidade") String hab, 
			@RequestParam("foto") MultipartFile foto,
			@RequestParam("curriculo") MultipartFile curriculo,
			HttpSession session,
			HttpServletRequest r) {
		
		
		Endereco endereco = new Endereco(
				r.getParameter("estado"),
				r.getParameter("cidade"),
				r.getParameter("bairro"),
				r.getParameter("numero"),
				r.getParameter("rua"),
				r.getParameter("cep")
		);
		byte[] inputStream=null;
		byte[] curriculoByte=null;
		
		try {
			if(!foto.isEmpty())
				inputStream = foto.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		try {
			if(!curriculo.isEmpty())
				curriculoByte = curriculo.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Desenvolvedor dev = new Desenvolvedor(
				r.getParameter("email"),
				inputStream,
				r.getParameter("senha"),
				endereco,
				r.getParameter("site"),
				r.getParameter("telefone"),
				r.getParameter("apresentacao"),
				r.getParameter("nome"),
				r.getParameter("cpf"),
				r.getParameter("dataNascimento"),
				Integer.parseInt(r.getParameter("tempoExperiencia")),
				r.getParameter("linkedIn"),
				r.getParameter("gitHub"),
				curriculoByte
				);
		
	
		DesenvolvedorAreaAtuacao area = new DesenvolvedorAreaAtuacao(); 
		DesenvolvedorHabilidade habilidade = new DesenvolvedorHabilidade();
		
		service.saveDesenvolvedor(dev);
		
		area.setEmailDesenvolvedor(dev.getEmail());
		habilidade.setEmailDesenvolvedor(dev.getEmail());
		String habilidades[] = hab.split(" ");
		
		//adiciona as areas de atuação
		for(String a: areas) {
			area.setAreaAtuacao(a);
			serviceA.saveArea(area);
		}
		
		for(String h: habilidades) {
			habilidade.setHabilidade(h);
			serviceH.saveHabilidade(habilidade);
		}

		session.setAttribute("perfil", dev);
		return "redirect:/devDashboard";
		
	}

	
	@RequestMapping(value = "/devDashboard", method = RequestMethod.GET)
	public String dashboard(Model model, HttpSession session) {
		model.addAttribute("perfil", session.getAttribute("perfil"));
		return "devDashboard";
	}
	
	@RequestMapping(value = "/devConfiguracoes", method = RequestMethod.GET)
	public String config(Model model, HttpSession session) {
		model.addAttribute("perfil", session.getAttribute("perfil"));
		return "devConfiguracoes";
	}
	
	@RequestMapping(value = "/devMeusDesafios", method = RequestMethod.GET)
	public String devMeusDesafios(Model model, HttpSession session) {
		Desenvolvedor dev = (Desenvolvedor) session.getAttribute("perfil");
		model.addAttribute("desafios",serviceD.getDesafiosInscritos(dev.getEmail()));

		model.addAttribute("service",serviceDH);
		model.addAttribute("perfil", session.getAttribute("perfil"));
		model.addAttribute("solucao", new Solucao());
		
		return "devDesafiosInscritos";
	}
	
	@PostMapping("/addDesenvolvedores")
	public List<Desenvolvedor> addEmpresas(List<Desenvolvedor> desenvolvedores) {
		return service.saveDesenvolvedores(desenvolvedores);
	}

	@GetMapping("/desenvolvedores")
	public List<Desenvolvedor> findAllDesenvolvedores() {
		return service.getDesenvolvedores();
	}

    @RequestMapping(value = "/imageDev/{dev_id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("dev_id") String email) throws IOException {
    	Desenvolvedor dev = service.getDesenvolvedorById(email);
    	
        byte[] imageContent = dev.getFoto();//get image from DAO based on id
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
    }
    
	@GetMapping("/desenvolvedorById/{email}")
	public String findEmpresaById(@PathVariable String email, Model model,HttpSession session) {
		model.addAttribute("dev", service.getDesenvolvedorById(email));
		model.addAttribute("service", serviceH);
		String area = "";
		
		List<DesenvolvedorAreaAtuacao> areas = serviceA.getAreas(email);
		
		for(int i = 0; i < areas.size(); i++) {
			if(i != areas.size()-1) {
				area += areas.get(i).getAreaAtuacao()+", ";
			}
			else
				area += areas.get(i).getAreaAtuacao();
			
		}
		model.addAttribute("perfil", session.getAttribute("perfil"));

		model.addAttribute("desafios", serviceSub.getInscricoes(email));
		model.addAttribute("area", area);
		model.addAttribute("serviceDev", service);
		return "perfilDesenvolvedor";
	}

	@GetMapping("/desenvolvedorByNome/{nome}")
	public Desenvolvedor findDesenvolvedorByNome(Model model, @PathVariable String nome) {
	
		return service.getDesenvolvedorByNome(nome);
	}

	@PutMapping("/updateDesenvolvedor")
	public Desenvolvedor updateDesenvolvedor(@RequestBody Desenvolvedor desenvolvedor) {
		return service.updateDesenvolvedor(desenvolvedor);
	}

	@PostMapping("/updateDadosPerfilDev")
	public String updateDesenvolvedorPerfil(Model model, HttpSession session, HttpServletRequest r) {
		Desenvolvedor dev = (Desenvolvedor) session.getAttribute("perfil");
		dev.setNome(r.getParameter("nome"));
		dev.setApresentacao(r.getParameter("apresentacao"));
		dev.setSite(r.getParameter("site"));
		dev.setTempoExperiencia((short) Integer.parseInt(r.getParameter("tempoExperiencia")));
		dev.setLinkedIn(r.getParameter("linkedIn"));
		dev.setGitHub(r.getParameter("gitHub"));
		service.updateDesenvolvedor(dev);
		return "redirect:/devConfiguracoes";
	}
	
	@PostMapping("/updateSenhaDev")
	public String updateDesenvolvedorSenha(Model model, HttpSession session, HttpServletRequest r) {
		Desenvolvedor dev = (Desenvolvedor) session.getAttribute("perfil");
		
		dev.setSenha(r.getParameter("senha"));
		service.updateDesenvolvedor(dev);
		return "redirect:/devConfiguracoes";
	}
	
	
	@PostMapping("/updateDadosPessoaisDev")
	public String updateDesenvolvedorDados(Model model, HttpSession session, HttpServletRequest r) {
		Desenvolvedor dev = (Desenvolvedor) session.getAttribute("perfil");
		dev.setTelefone(r.getParameter("telefone"));
		dev.setDataNascimento(r.getParameter("dataNascimento"));
		
		service.updateDesenvolvedor(dev);
		return "redirect:/devConfiguracoes";
	}
	
	
	@GetMapping("/deleteDesenvolvedor")
	public String deleteDesenvolvedor(Model model, HttpSession session) {
		Desenvolvedor dev = (Desenvolvedor) session.getAttribute("perfil");
		
		serviceA.deleteArea(dev.getEmail());
		serviceH.deleteHabilidade(dev.getEmail());
		serviceS.deleteSolucao(dev.getEmail());
		serviceSub.deleteInscricao(dev.getEmail());
		serviceN.deleteNotificacao(dev.getEmail());
		service.deleteDesenvolvedor(dev.getEmail());
		return "redirect:/";
	}
}
