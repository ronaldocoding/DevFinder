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

	@GetMapping("/desenvolvedorNotificacoes/{emailDesenvolvedor}")
	public List<DesenvolvedorNotificacao> findAllNotificacoes(@PathVariable String emailDesenvolvedor) {
		return service.getNotificacoes(emailDesenvolvedor);
	}

	@GetMapping("/desenvolvedorNotificacaoById/{emailDesenvolvedor}/{id}/{titulo}")
	public DesenvolvedorNotificacao findNotificacaoById(@PathVariable String emailDesenvolvedor, @PathVariable int id,
			@PathVariable String titulo) {
		DesenvolvedorNotificacaoId desenvolvedorNotificacaoId = new DesenvolvedorNotificacaoId(emailDesenvolvedor, id,
				titulo);
		return service.getNotificacaoById(desenvolvedorNotificacaoId);
	}

	@GetMapping("/desenvolvedorNotificacao/{emailDesenvolvedor}/{titulo}")
	public DesenvolvedorNotificacao findNotificacaoByTitulo(@PathVariable String emailDesenvolvedor,
			@PathVariable String titulo) {
		return service.getNotificacaoByTitulo(emailDesenvolvedor, titulo);
	}

	@DeleteMapping("/deleteDesenvolvedorNotificacao/{emailDesenvolvedor}/{id}/{titulo}")
	public String deleteNotificacao(@PathVariable String emailDesenvolvedor, @PathVariable int id,
			@PathVariable String titulo) {
		DesenvolvedorNotificacaoId desenvolvedorNotificacaoId = new DesenvolvedorNotificacaoId(emailDesenvolvedor, id,
				titulo);
		return service.deleteNotificacao(desenvolvedorNotificacaoId);
	}
}
