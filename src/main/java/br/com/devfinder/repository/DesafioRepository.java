package br.com.devfinder.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import br.com.devfinder.model.Desafio;
import br.com.devfinder.model.ids.DesafioId;

/**
 * @author Ronaldo Costa
 *
 */
public interface DesafioRepository extends JpaRepository<Desafio, DesafioId>, DesafioRepositoryCustom {

	Desafio findByNome(String nome);


	@Query(value = "SELECT * FROM DESAFIO WHERE EMAIL_EMPRESA = ?1", nativeQuery = true)
	List<Desafio> findAllByEmpresa(String emailEmpresa);
	
	@Query(value = "SELECT * FROM DESAFIO D, DESENVOLVEDOR_DESAFIO DD WHERE DD.EMAIL_DESENVOLVEDOR = ?1 AND DD.ID_DESAFIO=D.ID", nativeQuery = true)
	List<Desafio>findDesafioInscritos(String email);
	
	@Query(value = "select d.nome, count(*) as inscritos from desenvolvedor_desafio INNER JOIN desafio d on d.id=id_desafio where d.email_empresa=?1 group by id_desafio;", nativeQuery = true)
	List<Map<String,Integer>> findInscricoes(String email);
	
	@Query(value = "select count(*) as total, SUBSTRING(data_envio, 4, 2)*1 as mes from solucao where email_empresa_desafio=?1 group by SUBSTRING(data_envio, 4, 2) order by mes DESC limit 7;", nativeQuery=true)
	List<Map<String,Integer>> findSubmissoes(String email);
	
	@Query(value = "SELECT * FROM DESAFIO WHERE ID = ?1", nativeQuery = true)
	Desafio findById(int id);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM DESAFIO WHERE EMAIL_EMPRESA = ?1", nativeQuery = true)
	void deleteAllByEmpresa(String emailEmpresa);
	
}
