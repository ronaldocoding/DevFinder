package br.com.devfinder.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.devfinder.model.Desafio;
import br.com.devfinder.model.DesafioHabilidade;
import br.com.devfinder.model.Desenvolvedor;
import br.com.devfinder.model.Empresa;
import br.com.devfinder.model.Usuario;
import br.com.devfinder.model.ids.DesafioHabilidadeId;
import br.com.devfinder.model.ids.DesafioId;
import br.com.devfinder.service.DesafioHabilidadeService;
import br.com.devfinder.service.DesafioService;
import br.com.devfinder.service.DesenvolvedorService;
import br.com.devfinder.service.EmpresaService;

/**
 * @author Ronaldo Costa
 *
 */
@Controller
public class DesafioController {

	@Autowired
	private DesafioService service;	

	@Autowired
	private EmpresaService serviceEmpresa;
	
	@Autowired
	private DesafioHabilidadeService serviceDH;

	@Autowired
	private DesenvolvedorService serviceDev;
	
	@GetMapping("/addDesafio")
	public String formDesafio(Model model,HttpSession session) {
		model.addAttribute("desafio", new Desafio());
		Empresa user = (Empresa) session.getAttribute("perfil");
		model.addAttribute("email", user.getEmail());
		
        return "formDesafio";
    }
	
	@PostMapping("/addDesafio")
	public String formDesafio(RedirectAttributes redirectAttributes, 
			@ModelAttribute Desafio desafio, @RequestParam("habilidade") String hab,
			@RequestParam("email") String emailEmpresa) {
		
        desafio.setEmailEmpresa(emailEmpresa);
        service.saveDesafio(desafio);
        desafio = service.getDesafioByNome(desafio.getNome());
        String habilidades[] = hab.split(" ");
        
        DesafioHabilidade desafiohabilidade = new DesafioHabilidade();
        desafiohabilidade.setEmailEmpresa(desafio.getEmailEmpresa());
        desafiohabilidade.setIdDesafio(desafio.getId());
        for(int i = 0; i < habilidades.length; i++) {
        	desafiohabilidade.setHabilidade(habilidades[i]);
        	//return desafiohabilidade.getEmailEmpresa()+desafiohabilidade.getHabilidade()+desafiohabilidade.getIdDesafio();
        	serviceDH.saveHabilidade(desafiohabilidade);
        	//.saveHabilidade(desafiohabilidade); 
        }
      
        redirectAttributes.addFlashAttribute("page", 2);
        redirectAttributes.addFlashAttribute("email", emailEmpresa);
		return "redirect:/empMeusDesafios";
    }
	
	@PostMapping("/addDesafios")
	public List<Desafio> addDesafios(@RequestBody List<Desafio> desafios) {
		return service.saveDesafios(desafios);
	}


	@PostMapping("/updateDesafio")
	public String updateDesafio(Model model, HttpSession session, HttpServletRequest r) {
		Empresa emp = (Empresa) session.getAttribute("perfil");
		Desafio desafio = service.getDesafioById(new DesafioId(emp.getEmail(), Integer.parseInt(r.getParameter("id"))));
		desafio.setNome(r.getParameter("nome"));
		desafio.setDescricao(r.getParameter("descricao"));
		desafio.setDataFim(r.getParameter("dataFim"));
		desafio.setHorarioFim(r.getParameter("horarioFim"));
		service.updateDesafio(desafio);
		return "redirect:/viewDesafio/"+r.getParameter("id");
		
	}
	@GetMapping("/desafioById/{emailEmpresa}/{id}")
	public Desafio findDesafioById(Model model, @PathVariable String emailEmpresa, @PathVariable int id) {
		DesafioId desafioId = new DesafioId(emailEmpresa, id);
		return service.getDesafioById(desafioId);
	}

	@GetMapping("/desafioByNome/{nome}")
	public Desafio findDesafioByNome(@PathVariable String nome) {
		return service.getDesafioByNome(nome);
	}

	@GetMapping("/viewDesafio/{id}")
	public String viewDesafio(@PathVariable int id, Model model, HttpSession session) {
		Desafio d = service.getDesafioById(id);
		if(session.getAttribute("perfil") == null)
			return "n_logado";
		else {
			Usuario user = (Usuario) session.getAttribute("perfil");
			//return user.getEmail()+ " "+d.getEmailEmpresa();
			if(user.getEmail().equals(d.getEmailEmpresa())) {
				model.addAttribute("desafio", service.getDesafioById(id));
				model.addAttribute("service",serviceDH);
				return "viewDesafio";
			}
			else
				return user.getEmail() + d.getEmailEmpresa();
		}
		 
	}
	
	@PutMapping("/updateDesafio")
	public Desafio updateDesafio(@RequestBody Desafio desafio) {
		return service.updateDesafio(desafio);
	}
	@GetMapping("/deleteDesafio/{id}")
	public String deleteEmpresa(@PathVariable int id, HttpSession session) {
		Empresa emp=  (Empresa) session.getAttribute("perfil");
		String emailEmpresa = emp.getEmail();
		
		DesafioId desafioId = new DesafioId(emailEmpresa, id);
		for(DesafioHabilidade d: serviceDH.getHabilidades(emailEmpresa)){
			if(id == d.getIdDesafio()) {
				serviceDH.deleteHabilidade(new DesafioHabilidadeId(emailEmpresa, id, d.getHabilidade()));
		
			}
		}
		service.deleteDesafio(desafioId);

      
		return "redirect:/empMeusDesafios";
	}
	
	@GetMapping("/getInscricoes/{email}")
	@ResponseBody
	public ArrayList<Map<String, Integer>> getInscricoes(@PathVariable String email) {
		return service.getInscricoes(email);
	}
	
	@GetMapping("/getSubmissoes/{email}")
	@ResponseBody
	public ArrayList<Map<String, Integer>> getSubmissoes(@PathVariable String email) {
		return service.getSubmissoes(email);
	}
}
