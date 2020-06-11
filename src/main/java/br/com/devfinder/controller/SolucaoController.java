package br.com.devfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devfinder.model.Solucao;
import br.com.devfinder.model.ids.SolucaoId;
import br.com.devfinder.service.SolucaoService;

/**
 * @author Ronaldo Costa
 *
 */
@RestController
public class SolucaoController {

	@Autowired
	private SolucaoService service;

	@PostMapping("/addSolucao")
	public Solucao addSolucao(@RequestBody Solucao solucao) {
		return service.saveSolucao(solucao);
	}

	@PostMapping("/addSolucoes")
	public List<Solucao> addSolucoes(@RequestBody List<Solucao> solucoes) {
		return service.saveSolucoes(solucoes);
	}

	@GetMapping("/solucoesByDesafio/{emailEmpresa}/{idDesafio}")
	public List<Solucao> findAllHabilidadesByDesafio(@PathVariable String emailEmpresa, @PathVariable int idDesafio) {
		return service.getSolucoesByDesafio(emailEmpresa, idDesafio);
	}

	@GetMapping("/solucoesByDesenvolvedor/{emailDesenvolvedor}")
	public List<Solucao> findAllHabilidadesByDesenvolvedor(@PathVariable String emailDesenvolvedor) {
		return service.getSolucoesByDesenvolvedor(emailDesenvolvedor);
	}

	@GetMapping("/solucaoById/{emailEmpresa}/{emailDesenvolvedor}/{idDesafio}")
	public Solucao findSolucaoById(@PathVariable String emailEmpresa, @PathVariable String emailDesenvolvedor,
			@PathVariable int idDesafio) {
		SolucaoId solucaoId = new SolucaoId(emailDesenvolvedor, emailEmpresa, idDesafio);
		return service.getSolucaoById(solucaoId);
	}

	@DeleteMapping("/deleteSolucao/{id}")
	public String deleteSolucao(@PathVariable String emailEmpresa, @PathVariable String emailDesenvolvedor,
			@PathVariable int idDesafio) {
		SolucaoId solucaoId = new SolucaoId(emailDesenvolvedor, emailEmpresa, idDesafio);
		return service.deleteSolucao(solucaoId);
	}
}