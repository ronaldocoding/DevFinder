package br.com.devfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devfinder.model.Solucao;
import br.com.devfinder.model.ids.SolucaoId;

/**
 * @author Ronaldo Costa
 *
 */
public interface SolucaoRepository extends JpaRepository<Solucao, SolucaoId>{
}
