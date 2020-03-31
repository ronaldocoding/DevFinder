package br.com.devfinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.devfinder.model.EmpresaNotificacao;
import br.com.devfinder.model.ids.EmpresaNotificacaoId;

/**
 * @author Ronaldo Costa
 *
 */
public interface EmpresaNotificacaoRepository extends JpaRepository<EmpresaNotificacao, EmpresaNotificacaoId> {

	@Query(value = "SELECT FROM EMPRESA_NOTIFICACAO en WHERE en.EMAIL_EMPRESA = ?1 AND en.TITULO = TITULO", nativeQuery = true)
	EmpresaNotificacao findByTitulo(String emailEmpresa, String titulo);

	@Query(value = "SELECT * FROM EMPRESA_NOTIFICACAO en WHERE en.EMAIL_EMPRESA = ?1", nativeQuery = true)
	List<EmpresaNotificacao> findAllByEmpresa(String emailEmpresa);
}
