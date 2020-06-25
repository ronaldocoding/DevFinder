package br.com.devfinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.com.devfinder.model.DesenvolvedorHabilidade;
import br.com.devfinder.model.ids.DesenvolvedorHabilidadeId;

/**
 * @author Ronaldo Costa
 *
 */
public interface DesenvolvedorHabilidadeRepository
		extends JpaRepository<DesenvolvedorHabilidade, DesenvolvedorHabilidadeId> {

	@Query(value = "SELECT * FROM DESENVOLVEDOR_HABILIDADE WHERE EMAIL_DESENVOLVEDOR = ?1", nativeQuery = true)
	List<DesenvolvedorHabilidade> findAllByDesenvolvedor(String emailDesenvolvedor);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM DESENVOLVEDOR_HABILIDADE WHERE EMAIL_DESENVOLVEDOR = ?1", nativeQuery = true)
	void deleteAllByDesenvolvedor(String emailDesenvolvedor);
}
