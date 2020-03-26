package br.com.devfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devfinder.model.DesenvolvedorAreaAtuacao;
import br.com.devfinder.model.ids.DesenvolvedorAreaAtuacaoId;
import br.com.devfinder.service.DesenvolvedorAreaAtuacaoService;

/**
 * @author Ronaldo Costa
 *
 */
@RestController
public class DesenvolvedorAreaAtuacaoController {

	@Autowired
	private DesenvolvedorAreaAtuacaoService service;

	@PostMapping("/addDesenvolvedorAreaAtuacao")
	public DesenvolvedorAreaAtuacao addArea(@RequestBody DesenvolvedorAreaAtuacao area) {
		return service.saveArea(area);
	}

	@PostMapping("/addDesenvolvedorAreasAtuacao")
	public List<DesenvolvedorAreaAtuacao> addAreas(@RequestBody List<DesenvolvedorAreaAtuacao> areas) {
		return service.saveAreas(areas);
	}

	@GetMapping("/desenvolvedorAreasAtuacao")
	public List<DesenvolvedorAreaAtuacao> findAllAreas() {
		return service.getAreas();
	}

	@GetMapping("/desenvolvedorAreaAtuacaoById/{id}")
	public DesenvolvedorAreaAtuacao findAreaById(@PathVariable DesenvolvedorAreaAtuacaoId id) {
		return service.getAreaById(id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteArea(@PathVariable DesenvolvedorAreaAtuacaoId id) {
		return service.deleteArea(id);
	}
}
