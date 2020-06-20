package br.com.devfinder.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.devfinder.model.Desenvolvedor;
import br.com.devfinder.model.Usuario;
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
	public String search(Model model, @RequestParam("search") String pesquisa, HttpSession session) {
		
		model.addAttribute("pesquisa", pesquisa);
		
		if(session.getAttribute("perfil") == null)
			return "pesquisa";
		else {
			Usuario user = (Usuario) session.getAttribute("perfil");
			model.addAttribute("perfil", session.getAttribute("perfil"));
			if(serviceE.getEmpresaById(user.getEmail()) == null){
				return "devPesquisa";
			}
			else
				return "empPesquisa";
		}
		
	}
	
	@GetMapping("/search")
	public String search(Model model, HttpSession session) {
		if(session.getAttribute("perfil") == null)
			return "pesquisa";
		else {
			Usuario user = (Usuario) session.getAttribute("perfil");
			model.addAttribute("perfil", session.getAttribute("perfil"));
			if(serviceE.getEmpresaById(user.getEmail()) == null){
				return "devPesquisa";
			}
			else
				return "empPesquisa";
		}
	}
	@GetMapping("/redirectlogin")
	public String redirect(Model model,
			@ModelAttribute("perfil") String email){
		
			return email;
		
	}
	
	
	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		session.setAttribute("perfil", null);
		return "redirect:/";
	}
	
	
	@PostMapping("/redirectLogin")
	public String redirectPerfil(Model model,
			@RequestParam("email") String email, @RequestParam("senha") String senha, HttpSession session) {

		if(serviceE.getEmpresaById(email) != null) {
			session.setAttribute("perfil", serviceE.getEmpresaById(email));
			return "redirect:/empDashboard";
		
		}
		else {
			session.setAttribute("perfil", serviceD.getDesenvolvedorById(email));
			return "redirect:/devDashboard";
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
