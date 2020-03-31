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

	@GetMapping("/empresaNotificacoes/{emailEmpresa}")
	public List<EmpresaNotificacao> findAllNotificacoes(@PathVariable String emailEmpresa) {
		return service.getNotificacoes(emailEmpresa);
	}

	@GetMapping("/empresaNotificacaoById/{emailEmpresa}/{id}/{titulo}")
	public EmpresaNotificacao findNotificacaoById(@PathVariable String emailEmpresa, @PathVariable int id,
			@PathVariable String titulo) {
		EmpresaNotificacaoId empresaNotificacaoId = new EmpresaNotificacaoId(emailEmpresa, id, titulo);
		return service.getNotificacaoById(empresaNotificacaoId);
	}

	@GetMapping("/empresaNotificacao/{emailEmpresa}/{titulo}")
	public EmpresaNotificacao findNotificacaoByTitulo(@PathVariable String emailEmpresa, @PathVariable String titulo) {
		return service.getNotificacaoByTitulo(emailEmpresa, titulo);
	}

	@DeleteMapping("/deleteEmpresaNotificacao/{id}")
	public String deleteNotificacao(@PathVariable EmpresaNotificacaoId id) {
		return service.deleteNotificacao(id);
	}
}
