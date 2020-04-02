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

import br.com.devfinder.model.Desenvolvedor;
import br.com.devfinder.service.DesenvolvedorService;

/**
 * @author Ronaldo Costa
 *
 */
@RestController
public class DesenvolvedorController {

	@Autowired
	private DesenvolvedorService service;

	@PostMapping("/addDesenvolvedor")
	public Desenvolvedor addDesenvolvedor(@RequestBody Desenvolvedor desenvolvedor) {
		return service.saveDesenvolvedor(desenvolvedor);
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
	public Desenvolvedor findDesenvolvedorById(@PathVariable String email) {
		return service.getDesenvolvedorById(email);
	}

	@GetMapping("/desenvolvedorByNome/{nome}")
	public Desenvolvedor findDesenvolvedorByNome(@PathVariable String nome) {
		return service.getDesenvolvedorByNome(nome);
	}

	@PutMapping("/updateDesenvolvedor")
	public Desenvolvedor updateDesenvolvedor(@RequestBody Desenvolvedor desenvolvedor) {
		return service.updateDesenvolvedor(desenvolvedor);
	}

	@DeleteMapping("/deleteDesenvolvedor/{email}")
	public String deleteDesenvolvedor(@PathVariable String email) {
		return service.deleteDesenvolvedor(email);
	}
}
