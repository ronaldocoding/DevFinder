package br.com.devfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devfinder.model.Desafio;
import br.com.devfinder.model.ids.DesafioId;

/**
 * @author Ronaldo Costa
 *
 */
public interface DesafioRepository extends JpaRepository<Desafio, DesafioId>{

	Desafio findByNome(String nome);
}
