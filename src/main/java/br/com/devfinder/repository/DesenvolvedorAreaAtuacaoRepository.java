package br.com.devfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devfinder.model.DesenvolvedorAreaAtuacao;
import br.com.devfinder.model.ids.DesenvolvedorAreaAtuacaoId;

/**
 * @author Ronaldo Costa
 *
 */
public interface DesenvolvedorAreaAtuacaoRepository
		extends JpaRepository<DesenvolvedorAreaAtuacao, DesenvolvedorAreaAtuacaoId> {
}
