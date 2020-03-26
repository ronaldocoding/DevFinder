package br.com.devfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devfinder.model.Desafio;
import br.com.devfinder.model.ids.DesafioId;
import br.com.devfinder.service.DesafioService;

/**
 * @author Ronaldo Costa
 *
 */
@RestController
public class DesafioController {

	@Autowired
	private DesafioService service;

	@PostMapping("/addDesafio")
	public Desafio addDesafio(@RequestBody Desafio desafio) {
		return service.saveDesafio(desafio);
	}

	@PostMapping("/addDesafios")
	public List<Desafio> addDesafios(@RequestBody List<Desafio> desafios) {
		return service.saveDesafios(desafios);
	}

	@GetMapping("/desafios")
	public List<Desafio> findAllDesafios() {
		return service.getDesafios();
	}

	@GetMapping("/desafioById/{id}")
	public Desafio findEmpresaById(@PathVariable DesafioId id) {
		return service.getDesafioById(id);
	}

	@GetMapping("/desafio/{nome}")
	public Desafio findDesafioByNome(@PathVariable String nome) {
		return service.getDesafioByNome(nome);
	}

	@PutMapping("/update")
	public Desafio updateDesafio(@RequestBody Desafio desafio) {
		return service.updateDesafio(desafio);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmpresa(@PathVariable DesafioId id) {
		return service.deleteDesafio(id);
	}
}
