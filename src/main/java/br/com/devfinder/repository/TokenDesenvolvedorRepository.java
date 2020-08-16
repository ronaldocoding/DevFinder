package br.com.devfinder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.devfinder.model.TokenDesenvolvedor;
import br.com.devfinder.model.TokenEmpresa;
import br.com.devfinder.model.ids.TokenDesenvolvedorId;
import br.com.devfinder.model.ids.TokenEmpresaId;

/**
 * @author Marlon Faria
 *
 */
public interface TokenDesenvolvedorRepository extends JpaRepository<TokenDesenvolvedor, TokenDesenvolvedorId> {

	//Empresa findByNomeFantasia(String nomeFantasia);
	TokenDesenvolvedor findByToken(String token);
}