package br.com.devfinder.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.devfinder.model.Desafio;

public interface DesafioRepositoryCustom {
	 List<Desafio> findDesafio(String[] texto);
}
