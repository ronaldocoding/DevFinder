package br.com.devfinder.repository;

import java.util.List;

import br.com.devfinder.model.Desenvolvedor;

public interface DesenvolvedorRepositoryCustom {
	List<Desenvolvedor> findDesenvolvedor(String[] texto);
}
