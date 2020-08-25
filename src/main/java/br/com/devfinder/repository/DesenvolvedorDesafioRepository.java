package br.com.devfinder.repository;

import java.util.List;
import java.util.Map;

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
	
	@Query(value = "select count(*) as quantidade, submetido from desafio inner join desenvolvedor_desafio dd on dd.id_desafio=id and STR_TO_DATE(data_fim, '%Y-%m-%d') > curdate() and dd.email_desenvolvedor=?1 group by submetido;", nativeQuery=true)
	List<Map<Integer, Integer>> findInscricoes(String emailDev);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM DESENVOLVEDOR_DESAFIO WHERE EMAIL_DESENVOLVEDOR = ?1", nativeQuery = true)
	void deleteAllByDesenvolvedor(String emailDesenvolvedor);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM DESENVOLVEDOR_DESAFIO WHERE EMAIL_EMPRESA_DESAFIO = ?1", nativeQuery = true)
	void deleteAllByEmpresa(String emailEmpresa);
	
	@Modifying
	@Transactional
	@Query(value = "update DESENVOLVEDOR_DESAFIO set submetido=1 WHERE EMAIL_EMPRESA_DESAFIO = ?1 and email_desenvolvedor=?2 and id_desafio=?3", nativeQuery = true)
	void update(String emailEmpresa, String emaildev, int dev);
	
	
}
