package br.com.devfinder.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
	public String addDesenvolvedor(@ModelAttribute Desenvolvedor dev, 
			@ModelAttribute Endereco endereco, @RequestParam("area") ArrayList<String> areas,
			Model model, @RequestParam("habilidade") String hab, HttpSession session) {
		
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
