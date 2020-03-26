package br.com.devfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devfinder.model.DesenvolvedorNotificacao;
import br.com.devfinder.model.ids.DesenvolvedorNotificacaoId;
import br.com.devfinder.service.DesenvolvedorNotificacaoService;

/**
 * @author Ronaldo Costa
 *
 */
@RestController
public class DesenvolvedorNotificacaoController {

	@Autowired
	private DesenvolvedorNotificacaoService service;

	@PostMapping("/addDesenvolvedorNotificacao")
	public DesenvolvedorNotificacao addNotificao(@RequestBody DesenvolvedorNotificacao notificacao) {
		return service.saveNotificacao(notificacao);
	}

	@PostMapping("/addDesenvolvedorNotificacoes")
	public List<DesenvolvedorNotificacao> addNotificacoes(@RequestBody List<DesenvolvedorNotificacao> notificacoes) {
		return service.saveNotificacoes(notificacoes);
	}

	@GetMapping("/desenvolvedorNotificacoes")
	public List<DesenvolvedorNotificacao> findAllNotificacoes() {
		return service.getNotificacoes();
	}

	@GetMapping("/desenvolvedorNotificacaoById/{id}")
	public DesenvolvedorNotificacao findNotificacaoById(@PathVariable DesenvolvedorNotificacaoId id) {
		return service.getNotificacaoById(id);
	}

	@GetMapping("/desenvolvedorNotificacao/{titulo}")
	public DesenvolvedorNotificacao findNotificacaoByTitulo(@PathVariable String titulo) {
		return service.getNotificacaoByTitulo(titulo);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteNotificacao(@PathVariable DesenvolvedorNotificacaoId id) {
		return service.deleteNotificacao(id);
	}
}
