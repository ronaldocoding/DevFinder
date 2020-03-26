package br.com.devfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devfinder.model.DesenvolvedorNotificacao;
import br.com.devfinder.model.ids.DesenvolvedorNotificacaoId;
import br.com.devfinder.repository.DesenvolvedorNotificacaoRepository;

/**
 * @author Ronaldo Costa
 *
 */
@Service
public class DesenvolvedorNotificacaoService {

	@Autowired
	private DesenvolvedorNotificacaoRepository repository;
	
	/**
	 * Métodos POST
	 * */
	public DesenvolvedorNotificacao saveNotificacao(DesenvolvedorNotificacao notificacao) {
		return repository.save(notificacao);
	}
	
	public List<DesenvolvedorNotificacao> saveNotificacoes(List<DesenvolvedorNotificacao> notificacoes) {
		return repository.saveAll(notificacoes);
	}
	
	/**
	 * Métodos GET
	 * */
	public List<DesenvolvedorNotificacao> getNotificacoes() {
		return repository.findAll();
	}
	
	public DesenvolvedorNotificacao getNotificacaoById(DesenvolvedorNotificacaoId id) {
		return repository.findById(id).orElse(null);
	}
	
	public DesenvolvedorNotificacao getNotificacaoByTitulo(String titulo) {
		return repository.findByTitulo(titulo);
	}
	
	/**
	 * Método DELETE
	 * */
	public String deleteNotificacao(DesenvolvedorNotificacaoId id) {
		repository.deleteById(id);
		return "desenvolvedorNotificacao deletada: " + id;
	}
}
