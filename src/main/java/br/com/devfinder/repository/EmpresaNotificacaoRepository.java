package br.com.devfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devfinder.model.EmpresaNotificacao;
import br.com.devfinder.model.ids.EmpresaNotificacaoId;

/**
 * @author Ronaldo Costa
 *
 */
public interface EmpresaNotificacaoRepository extends JpaRepository<EmpresaNotificacao, EmpresaNotificacaoId> {

	EmpresaNotificacao findByTitulo(String titulo);
}
