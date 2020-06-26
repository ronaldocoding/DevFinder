package br.com.devfinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.com.devfinder.model.Solucao;
import br.com.devfinder.model.ids.SolucaoId;

/**
 * @author Ronaldo Costa
 *
 */
public interface SolucaoRepository extends JpaRepository<Solucao, SolucaoId> {
	
	@Query(value = "SELECT * FROM SOLUCAO WHERE EMAIL_EMPRESA_DESAFIO = ?1 AND ID_DESAFIO = ?2", nativeQuery = true)
	List<Solucao> findAllByDesafio(String emailEmpresa, int idDesafio);
	
	@Query(value = "SELECT * FROM SOLUCAO WHERE EMAIL_DESENVOLVEDOR = ?1", nativeQuery = true)
	List<Solucao> findAllByDesenvolvedor(String emailDesenvolvedor);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM SOLUCAO WHERE EMAIL_DESENVOLVEDOR = ?1", nativeQuery = true)
	void deleteAllByDesenvolvedor(String emailDesenvolvedor);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM SOLUCAO WHERE EMAIL_EMPRESA_DESAFIO = ?1", nativeQuery = true)
	void deleteAllByEmpresa(String emailEmpresa);
}
