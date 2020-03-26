package br.com.devfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devfinder.model.DesenvolvedorHabilidade;
import br.com.devfinder.model.ids.DesenvolvedorHabilidadeId;

/**
 * @author Ronaldo Costa
 *
 */
public interface DesenvolvedorHabilidadeRepository
		extends JpaRepository<DesenvolvedorHabilidade, DesenvolvedorHabilidadeId> {
}
