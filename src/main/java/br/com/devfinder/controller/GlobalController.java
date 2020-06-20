package br.com.devfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.devfinder.model.Desenvolvedor;
import br.com.devfinder.service.DesenvolvedorService;
import br.com.devfinder.service.EmpresaService;

@ControllerAdvice

public class GlobalController {

	@Autowired
	private DesenvolvedorService serviceDev;
	
	
	@Autowired
	private EmpresaService serviceEmp;
	
	@ModelAttribute("perfil")
	public String teste(@ModelAttribute("email") String email) {
		return email;
	}
}
