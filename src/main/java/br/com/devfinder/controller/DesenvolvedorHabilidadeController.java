package br.com.devfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devfinder.model.DesenvolvedorHabilidade;
import br.com.devfinder.model.ids.DesenvolvedorHabilidadeId;
import br.com.devfinder.service.DesenvolvedorHabilidadeService;

/**
 * @author Ronaldo Costa
 *
 */
@RestController
public class DesenvolvedorHabilidadeController {

	@Autowired
	private DesenvolvedorHabilidadeService service;

	@PostMapping("/addDesenvolvedorHabilidade")
	public DesenvolvedorHabilidade addHabilidade(@RequestBody DesenvolvedorHabilidade habilidade) {
		return service.saveHabilidade(habilidade);
	}

	@PostMapping("/addDesenvolvedorHabilidades")
	public List<DesenvolvedorHabilidade> addHabilidades(@RequestBody List<DesenvolvedorHabilidade> habilidades) {
		return service.saveHabilidades(habilidades);
	}

	@GetMapping("/desenvolvedorHabilidades")
	public List<DesenvolvedorHabilidade> findAllHabilidades() {
		return service.getHabilidades();
	}

	@GetMapping("/desenvolvedorHabilidadeById/{id}")
	public DesenvolvedorHabilidade findHabilidadeById(@PathVariable DesenvolvedorHabilidadeId id) {
		return service.getHabilidadeById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteHabilidade(@PathVariable DesenvolvedorHabilidadeId id) {
		return service.deleteHabilidade(id);
	}
}
