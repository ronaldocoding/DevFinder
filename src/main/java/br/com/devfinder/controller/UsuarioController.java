package br.com.devfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.devfinder.service.DesafioHabilidadeService;
import br.com.devfinder.service.DesafioService;
import br.com.devfinder.service.DesenvolvedorService;
import br.com.devfinder.service.EmpresaService;

@Controller
public class UsuarioController {

	@Autowired
	private EmpresaService serviceE;
	
	@Autowired
	private DesafioService serviceDe;
	
	@Autowired
	private DesafioHabilidadeService serviceDH;
	
	
	@Autowired
	private DesenvolvedorService serviceD;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("email", new String());
		model.addAttribute("senha", new String());
		
		return "homepage";
	}
	
	@GetMapping("/searchResult")
	public String teste2(Model model, @RequestParam(value="texto[]") String[] texto) {
		model.addAttribute("desafios",serviceDe.getDesafios(texto));
		model.addAttribute("devs", serviceD.getDesenvolvedores(texto));
		model.addAttribute("emps", serviceE.getEmpresas(texto));
		model.addAttribute("service", serviceDH);
		return "pesquisaResult.html";
	}
	
	@PostMapping("/search")
	public String search(Model model, @RequestParam("search") String pesquisa) {
		model.addAttribute("pesquisa", pesquisa);
		return "pesquisa";
	}
	
	@GetMapping("/search")
	public String search(Model model) {
		return "pesquisa";
	}
	@GetMapping("/redirectLogin")
	public String redirect(Model model,
			@ModelAttribute("email") String email, @ModelAttribute(value = "page") String page){


		if(page == null)
			model.addAttribute("page", 1);
		else
			model.addAttribute("page", page);
		
		if(serviceE.getEmpresaById(email) != null) {
			model.addAttribute("empresa",serviceE.getEmpresaById(email));
			return "empInicio";
		}
		else {
			model.addAttribute("dev",serviceD.getDesenvolvedorById(email));
			return "devInicio";
		}
	}
	
	
	@GetMapping("/logout")
	public String logout(Model model) {
		return "redirect:/";
	}
	
	
	@PostMapping("/redirectLogin")
	public String redirectPerfil(Model model,
			@RequestParam("email") String email, @RequestParam("senha") String senha) {

		if(serviceE.getEmpresaById(email) != null) {
			model.addAttribute("empresa", serviceE.getEmpresaById(email));
			return "empInicio";
		}
		else {
			model.addAttribute("dev", serviceD.getDesenvolvedorById(email));
			return "devInicio";
		}
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public boolean login(@RequestParam("email") String email,
						@RequestParam("senha") String senha) {
		
		if(serviceE.getEmpresaById(email) != null) {
			if(serviceE.getEmpresaById(email).getSenha().equals(senha)) {
				return true;
			}
			else {
				return false;
			}
		}
		
		if(serviceD.getDesenvolvedorById(email) != null) {
			if(serviceD.getDesenvolvedorById(email).getSenha().equals(senha)) {
				return true;
			}
			else {
				return false;
			}
		}
		

		 return false;
	}
	
}
