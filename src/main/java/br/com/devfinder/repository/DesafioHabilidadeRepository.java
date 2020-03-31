package br.com.devfinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import br.com.devfinder.model.DesafioHabilidade;
import br.com.devfinder.model.ids.DesafioHabilidadeId;

/**
 * @author Ronaldo Costa
 *
 */
@Service
public interface DesafioHabilidadeRepository extends JpaRepository<DesafioHabilidade, DesafioHabilidadeId> {

	@Query(value = "SELECT * FROM DESAFIO_HABILIDADE WHERE EMAIL_EMPRESA_DESAFIO = ?1 AND ID_DESAFIO = ?2", nativeQuery = true)
	List<DesafioHabilidade> findAllByDesafio(String emailEmpresa, int idDesafio);
}
