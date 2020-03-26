package br.com.devfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.com.devfinder.model.DesafioHabilidade;
import br.com.devfinder.model.ids.DesafioHabilidadeId;

/**
 * @author Ronaldo Costa
 *
 */
@Service
public interface DesafioHabilidadeRepository extends JpaRepository<DesafioHabilidade, DesafioHabilidadeId> {
}
