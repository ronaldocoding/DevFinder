package br.com.devfinder.repository;

import java.util.List;

import br.com.devfinder.model.Empresa;

public interface EmpresaRepositoryCustom {
	List<Empresa> findEmpresa(String[] texto);
}
