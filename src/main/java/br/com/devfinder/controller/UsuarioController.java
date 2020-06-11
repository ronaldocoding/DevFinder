package br.com.devfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.devfinder.service.DesenvolvedorService;
import br.com.devfinder.service.EmpresaService;

@Controller
public class UsuarioController {

	@Autowired
	private EmpresaService serviceE;

	private boolean tryLogin=true;
	
	@Autowired
	private DesenvolvedorService serviceD;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("email", new String());
		model.addAttribute("senha", new String());
		
		return "homepage";
	}
	
	@GetMapping("/login")
	public String teste(Model model,
			@RequestParam("email") String email,
			@RequestParam("senha") String senha) {
		
		if(!tryLogin) {
			model.addAttribute("false", true);
			tryLogin=true;
			return "homepage";
		}
		if(serviceE.getEmpresaById(email) != null) {
			if(serviceE.getEmpresaById(email).getSenha().equals(senha)) {
				tryLogin = false;
				return "redirect:inicioEmpresa/"+email;
			}
			else {
				model.addAttribute("email", email);
				model.addAttribute("flag", true);
				tryLogin = true;
				return "homepage";
			}
		}
		
		if(serviceD.getDesenvolvedorById(email) != null) {
			if(serviceD.getDesenvolvedorById(email).getSenha().equals(senha)) {
				tryLogin = false;
				return "redirect:inicioDev/"+email;
			}
			else {
				model.addAttribute("email", email);
				model.addAttribute("flag", true);
				tryLogin = true;
				return "homepage";
			}
		}
		model.addAttribute("email", email);
		model.addAttribute("flag", true);
		tryLogin = true;
		return "homepage";

		
	}
}
