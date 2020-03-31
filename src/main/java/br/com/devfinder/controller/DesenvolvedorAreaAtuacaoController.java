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

	@GetMapping("/desenvolvedorAreasAtuacao/{emailDesenvolvedor}")
	public List<DesenvolvedorAreaAtuacao> findAllAreas(@PathVariable String emailDesenvolvedor) {
		return service.getAreas(emailDesenvolvedor);
	}

	@GetMapping("/desenvolvedorAreaAtuacaoById/{emailDesenvolvedor}/{areaAtuacao}")
	public DesenvolvedorAreaAtuacao findAreaById(@PathVariable String emailDesenvolvedor,
			@PathVariable String areaAtuacao) {
		DesenvolvedorAreaAtuacaoId desenvolvedorAreaAtuacaoId = new DesenvolvedorAreaAtuacaoId(emailDesenvolvedor,
				areaAtuacao);
		return service.getAreaById(desenvolvedorAreaAtuacaoId);
	}

	@DeleteMapping("/deleteDesenvolvedorAreaAtuacao/{emailDesenvolvedor}/{areaAtuacao}")
	public String deleteArea(@PathVariable String emailDesenvolvedor, @PathVariable String areaAtuacao) {
		DesenvolvedorAreaAtuacaoId desenvolvedorAreaAtuacaoId = new DesenvolvedorAreaAtuacaoId(emailDesenvolvedor,
				areaAtuacao);
		return service.deleteArea(desenvolvedorAreaAtuacaoId);
	}
}
