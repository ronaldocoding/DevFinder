package br.com.devfinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.com.devfinder.model.DesenvolvedorNotificacao;
import br.com.devfinder.model.ids.DesenvolvedorNotificacaoId;

/**
 * @author Ronaldo Costa
 *
 */
public interface DesenvolvedorNotificacaoRepository
		extends JpaRepository<DesenvolvedorNotificacao, DesenvolvedorNotificacaoId> {

	@Query(value = "SELECT * FROM DESENVOLVEDOR_NOTIFICACAO WHERE EMAIL_DESENVOLVEDOR = ?1 AND TITULO = ?2", nativeQuery = true)
	DesenvolvedorNotificacao findByTitulo(String emailDesenvolvedor, String titulo);

	@Query(value = "SELECT * FROM DESENVOLVEDOR_NOTIFICACAO WHERE EMAIL_DESENVOLVEDOR = ?1", nativeQuery = true)
	List<DesenvolvedorNotificacao> findAllByDesenvolvedor(String emailDesenvolvedor);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM DESENVOLVEDOR_NOTIFICACAO WHERE EMAIL_DESENVOLVEDOR = ?1", nativeQuery = true)
	void deleteAllByDesenvolvedor(String emailDesenvolvedor);
}
