package br.com.devfinder.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devfinder.model.Desenvolvedor;
import br.com.devfinder.model.DesenvolvedorDesafio;
import br.com.devfinder.model.ids.DesenvolvedorDesafioId;
import br.com.devfinder.service.DesenvolvedorDesafioService;

/**
 * @author Ronaldo Costa
 *
 */
@Controller
public class DesenvolvedorDesafioController {

	@Autowired
	private DesenvolvedorDesafioService service;
	
	@GetMapping("/addInscricao")
	@ResponseBody
	public String addInscricao(@RequestParam("id") int id, @RequestParam("email") String email, HttpSession session) {
		Desenvolvedor dev = (Desenvolvedor) session.getAttribute("perfil");
		service.saveInscricao(new DesenvolvedorDesafio(dev.getEmail(), email, id));
		return "sucess";
	}

	@PostMapping("/addInscricoes")
	public List<DesenvolvedorDesafio> addInscricoes(@RequestBody List<DesenvolvedorDesafio> inscricoes) {
		return service.saveInscricoes(inscricoes);
	}

	@GetMapping("/inscricoesByDesafio/{emailEmpresa}/{idDesafio}")
	public List<DesenvolvedorDesafio> findAllInscricoesByDesafio(@PathVariable String emailEmpresa, @PathVariable int idDesafio) {
		return service.getInscricoes(emailEmpresa, idDesafio);
	}

	@GetMapping("/inscricaoById/{emailEmpresa}/{emailDesenvolvedor}/{idDesafio}")
	public DesenvolvedorDesafio findInscricaoById(@PathVariable String emailEmpresa, @PathVariable String emailDesenvolvedor,
			@PathVariable int idDesafio) {
		DesenvolvedorDesafioId id = new DesenvolvedorDesafioId(emailDesenvolvedor, emailEmpresa, idDesafio);
		return service.getInscricaoById(id);
	}

	@GetMapping("/deleteInscricao/{emailEmpresa}/{idDesafio}")
	public String deleteInscricao(@PathVariable String emailEmpresa,@PathVariable int idDesafio, HttpSession session) {
		Desenvolvedor dev = (Desenvolvedor) session.getAttribute("perfil");
		DesenvolvedorDesafioId id = new DesenvolvedorDesafioId(dev.getEmail(), emailEmpresa, idDesafio);
		service.deleteInscricao(id);
		return "redirect:/devMeusDesafios";
	}
}
