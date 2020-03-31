package br.com.devfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devfinder.model.DesafioHabilidade;
import br.com.devfinder.model.ids.DesafioHabilidadeId;
import br.com.devfinder.service.DesafioHabilidadeService;

/**
 * @author Ronaldo Costa
 *
 */
@RestController
public class DesafioHabilidadeController {

	@Autowired
	private DesafioHabilidadeService service;

	@PostMapping("/addDesafioHabilidade")
	public DesafioHabilidade addHabilidade(@RequestBody DesafioHabilidade habilidade) {
		return service.saveHabilidade(habilidade);
	}

	@PostMapping("/addDesafioHabilidades")
	public List<DesafioHabilidade> addHabilidades(@RequestBody List<DesafioHabilidade> habilidades) {
		return service.saveHabilidades(habilidades);
	}

	@GetMapping("/desafioHabilidades/{emailEmpresa}/{idDesafio}")
	public List<DesafioHabilidade> findAllHabilidades(@PathVariable String emailEmpresa, @PathVariable int idDesafio) {
		return service.getHabilidades(emailEmpresa, idDesafio);
	}

	@GetMapping("/desafioHabilidadeById/{emailEmpresa}/{idDesafio}/{habilidade}")
	public DesafioHabilidade findHabilidadeById(@PathVariable String emailEmpresa, @PathVariable int idDesafio,
			@PathVariable String habilidade) {
		DesafioHabilidadeId desafioHabilidadeId = new DesafioHabilidadeId(emailEmpresa, idDesafio, habilidade);
		return service.getHabilidadeById(desafioHabilidadeId);
	}

	@DeleteMapping("/deleteDesafioHabilidade/{id}")
	public String deleteHabilidade(@PathVariable DesafioHabilidadeId id) {
		return service.deleteHabilidade(id);
	}
}