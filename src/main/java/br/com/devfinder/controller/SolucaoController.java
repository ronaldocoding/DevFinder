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

	@GetMapping("/solucoes")
	public List<Solucao> findAllHabilidades() {
		return service.getSolucoes();
	}

	@GetMapping("/solucaoById/{id}")
	public Solucao findSolucaoById(@PathVariable SolucaoId id) {
		return service.getSolucaoById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteSolucao(@PathVariable SolucaoId id) {
		return service.deleteSolucao(id);
	}
}
