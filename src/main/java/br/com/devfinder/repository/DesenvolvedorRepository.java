package br.com.devfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devfinder.model.Desenvolvedor;

/**
 * @author Ronaldo Costa
 *
 */
public interface DesenvolvedorRepository extends JpaRepository<Desenvolvedor, String>{

	Desenvolvedor findByNome(String nome);
}
