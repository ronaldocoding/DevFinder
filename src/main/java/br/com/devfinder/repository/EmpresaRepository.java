package br.com.devfinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devfinder.model.Empresa;

/**
 * @author Ronaldo Costa
 *
 */
public interface EmpresaRepository extends JpaRepository<Empresa, String>,EmpresaRepositoryCustom {

	Empresa findByNomeFantasia(String nomeFantasia);
}