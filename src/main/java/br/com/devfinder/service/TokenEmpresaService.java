package br.com.devfinder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devfinder.model.Desafio;
import br.com.devfinder.model.DesafioHabilidade;
import br.com.devfinder.model.TokenEmpresa;
import br.com.devfinder.model.ids.DesafioHabilidadeId;
import br.com.devfinder.model.ids.DesafioId;
import br.com.devfinder.model.ids.TokenEmpresaId;
import br.com.devfinder.repository.DesafioRepository;
import br.com.devfinder.repository.TokenEmpresaRepository;

/**
 * @author Marlon Faria
 *
 */
@Service
public class TokenEmpresaService {

	@Autowired
	private TokenEmpresaRepository repository;
	
	/**
	 * Métodos POST
	 */
	public TokenEmpresa saveToken(TokenEmpresa token) {
		return repository.save(token);
	}


	/**
	 * Métodos GET
	 */
	
	public TokenEmpresa getTokenEmpresaById(TokenEmpresaId id) {
		return repository.findById(id).orElse(null);
		
	}
	
	public TokenEmpresa getTokenEmpresaByToken(String token) {
		return repository.findByToken(token);
		
	}
	/**
	 * Método DELETE
	 */
	
	public void deleteToken(TokenEmpresaId idToken) {
		repository.deleteById(idToken);
	}
	
	/**
	 * Método PUT
	 */
	public TokenEmpresa updateToken(TokenEmpresaId idToken) {
		TokenEmpresa existingDesafio = repository.findById(idToken).orElse(null);
		existingDesafio.setAtivo(false);
		return repository.save(existingDesafio);
	}
	
	
}
