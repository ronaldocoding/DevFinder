package br.com.devfinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.devfinder.model.Desafio;
import br.com.devfinder.model.ids.DesafioId;

/**
 * @author Ronaldo Costa
 *
 */
public interface DesafioRepository extends JpaRepository<Desafio, DesafioId> {

	Desafio findByNome(String nome);


	@Query(value = "SELECT * FROM DESAFIO WHERE EMAIL_EMPRESA = ?1", nativeQuery = true)
	List<Desafio> findAllByEmpresa(String emailEmpresa);

	
}
