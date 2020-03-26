package br.com.devfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devfinder.model.DesenvolvedorNotificacao;
import br.com.devfinder.model.ids.DesenvolvedorNotificacaoId;

/**
 * @author Ronaldo Costa
 *
 */
public interface DesenvolvedorNotificacaoRepository
		extends JpaRepository<DesenvolvedorNotificacao, DesenvolvedorNotificacaoId> {

	DesenvolvedorNotificacao findByTitulo(String titulo);
}
