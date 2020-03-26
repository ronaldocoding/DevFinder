package br.com.devfinder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.devfinder.model.EmpresaNotificacao;
import br.com.devfinder.model.ids.EmpresaNotificacaoId;
import br.com.devfinder.service.EmpresaNotificacaoService;

/**
 * @author Ronaldo Costa
 *
 */
@RestController
public class EmpresaNotificacaoController {

	@Autowired
	private EmpresaNotificacaoService service;
	
	@PostMapping("/addEmpresaNotificacao")
	public EmpresaNotificacao addNotificao(@RequestBody EmpresaNotificacao notificacao) {
		return service.saveNotificacao(notificacao);
	}
	
	@PostMapping("/addEmpresaNotificacoes")
	public List<EmpresaNotificacao> addNotificacoes(@RequestBody List<EmpresaNotificacao> notificacoes) {
		return service.saveNotificacoes(notificacoes);
	}
	
	@GetMapping("/empresaNotificacoes")
	public List<EmpresaNotificacao> findAllNotificacoes() {
		return service.getNotificacoes();
	}
	
	@GetMapping("/empresaNotificacaoById/{id}")
	public EmpresaNotificacao findNotificacaoById(@PathVariable EmpresaNotificacaoId id) {
		return service.getNotificacaoById(id);
	}
	
	@GetMapping("/empresaNotificacao/{titulo}")
	public EmpresaNotificacao findNotificacaoByTitulo(@PathVariable String titulo) {
		return service.getNotificacaoByTitulo(titulo);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteNotificacao(@PathVariable EmpresaNotificacaoId id) {
		return service.deleteNotificacao(id);
	}
	
}
