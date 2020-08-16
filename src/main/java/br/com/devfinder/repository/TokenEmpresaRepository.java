package br.com.devfinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devfinder.model.TokenEmpresa;
import br.com.devfinder.model.ids.TokenEmpresaId;

/**
 * @author Marlon Faria
 *
 */
public interface TokenEmpresaRepository extends JpaRepository<TokenEmpresa, TokenEmpresaId> {

	//Empresa findByNomeFantasia(String nomeFantasia);
	TokenEmpresa findByToken(String token);
}