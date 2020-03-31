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

	@GetMapping("/desenvolvedorHabilidades/{emailDesenvolvedor}")
	public List<DesenvolvedorHabilidade> findAllHabilidades(@PathVariable String emailDesenvolvedor) {
		return service.getHabilidades(emailDesenvolvedor);
	}

	@GetMapping("/desenvolvedorHabilidadeById/{emailDesenvolvedor}/{habilidade}")
	public DesenvolvedorHabilidade findHabilidadeById(@PathVariable String emailDesenvolvedor, @PathVariable String habilidade) {
		DesenvolvedorHabilidadeId desenvolvedorHabilidadeId = new DesenvolvedorHabilidadeId(emailDesenvolvedor, habilidade);
		return service.getHabilidadeById(desenvolvedorHabilidadeId);
	}

	@DeleteMapping("/deleteDesenvolvedorHabilidade/{emailDesenvolvedor}/{habilidade}")
	public String deleteHabilidade(@PathVariable String emailDesenvolvedor, @PathVariable String habilidade) {
		DesenvolvedorHabilidadeId desenvolvedorHabilidadeId = new DesenvolvedorHabilidadeId(emailDesenvolvedor, habilidade);
		return service.deleteHabilidade(desenvolvedorHabilidadeId);
	}
}
