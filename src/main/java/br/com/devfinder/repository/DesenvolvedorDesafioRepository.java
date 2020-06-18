package br.com.devfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devfinder.model.DesenvolvedorDesafio;
import br.com.devfinder.model.ids.DesenvolvedorDesafioId;

public interface DesenvolvedorDesafioRepository extends JpaRepository<DesenvolvedorDesafio, DesenvolvedorDesafioId> {

}
