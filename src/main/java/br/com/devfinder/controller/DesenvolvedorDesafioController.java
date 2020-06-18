package br.com.devfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devfinder.model.DesenvolvedorDesafio;
import br.com.devfinder.model.ids.DesenvolvedorDesafioId;
import br.com.devfinder.service.DesenvolvedorDesafioService;

/**
 * @author Ronaldo Costa
 *
 */
@RestController
public class DesenvolvedorDesafioController {

	@Autowired
	private DesenvolvedorDesafioService service;
	
	@PostMapping("/addInscricao")
	public DesenvolvedorDesafio addInscricao(@RequestBody DesenvolvedorDesafio inscricao) {
		return service.saveInscricao(inscricao);
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

	@DeleteMapping("/deleteInscricao/{id}")
	public String deleteInscricao(@PathVariable String emailEmpresa, @PathVariable String emailDesenvolvedor,
			@PathVariable int idDesafio) {
		DesenvolvedorDesafioId id = new DesenvolvedorDesafioId(emailDesenvolvedor, emailEmpresa, idDesafio);
		return service.deleteInscricao(id);
	}
}
