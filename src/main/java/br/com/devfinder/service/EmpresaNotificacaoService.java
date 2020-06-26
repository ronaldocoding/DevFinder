package br.com.devfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devfinder.model.EmpresaNotificacao;
import br.com.devfinder.model.ids.EmpresaNotificacaoId;
import br.com.devfinder.repository.EmpresaNotificacaoRepository;

/**
 * @author Ronaldo Costa
 *
 */
@Service
public class EmpresaNotificacaoService {

	@Autowired
	private EmpresaNotificacaoRepository repository;

	/**
	 * Métodos POST
	 */
	public EmpresaNotificacao saveNotificacao(EmpresaNotificacao notificacao) {
		return repository.save(notificacao);
	}

	public List<EmpresaNotificacao> saveNotificacoes(List<EmpresaNotificacao> notificacoes) {
		return repository.saveAll(notificacoes);
	}

	/**
	 * Métodos GET
	 */
	public List<EmpresaNotificacao> getNotificacoes(String emailEmpresa) {
		return repository.findAllByEmpresa(emailEmpresa);
	}

	public EmpresaNotificacao getNotificacaoById(EmpresaNotificacaoId id) {
		return repository.findById(id).orElse(null);
	}

	public EmpresaNotificacao getNotificacaoByTitulo(String emailEmpresa, String titulo) {
		return repository.findByTitulo(emailEmpresa, titulo);
	}

	/**
	 * Método DELETE
	 */
	public String deleteNotificacao(EmpresaNotificacaoId id) {
		repository.deleteById(id);
		return "empresaNotificacao deletada: " + id;
	}

	public void deleteNotificacaoByEmpresa(String emailEmpresa) {
		repository.deleteAllByEmpresa(emailEmpresa);
	}
}
