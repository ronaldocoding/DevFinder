package br.com.devfinder.repository;

import java.util.List;

/**
 * @author Ronaldo Costa
 *
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.com.devfinder.model.Desafio;
import br.com.devfinder.model.DesenvolvedorDesafio;
import br.com.devfinder.model.ids.DesenvolvedorDesafioId;

public interface DesenvolvedorDesafioRepository extends JpaRepository<DesenvolvedorDesafio, DesenvolvedorDesafioId> {

	@Query(value = "SELECT * FROM DESENVOLVEDOR_DESAFIO WHERE EMAIL_EMPRESA_DESAFIO = ?1 AND ID_DESAFIO = ?2", nativeQuery = true)
	List<DesenvolvedorDesafio> findAllByDesafio(String emailEmpresa, int idDesafio);

	@Query(value = "SELECT * FROM DESENVOLVEDOR_DESAFIO WHERE EMAIL_DESENVOLVEDOR = ?1", nativeQuery = true)
	List<DesenvolvedorDesafio> findAllByDesenvolvedor(String emaildev);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM DESENVOLVEDOR_DESAFIO WHERE EMAIL_DESENVOLVEDOR = ?1", nativeQuery = true)
	void deleteAllByDesenvolvedor(String emailDesenvolvedor);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM DESENVOLVEDOR_DESAFIO WHERE EMAIL_EMPRESA_DESAFIO = ?1", nativeQuery = true)
	void deleteAllByEmpresa(String emailEmpresa);
}
