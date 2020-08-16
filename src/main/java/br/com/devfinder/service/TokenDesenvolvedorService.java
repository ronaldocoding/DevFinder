package br.com.devfinder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devfinder.model.Desafio;
import br.com.devfinder.model.DesafioHabilidade;
import br.com.devfinder.model.TokenDesenvolvedor;
import br.com.devfinder.model.TokenEmpresa;
import br.com.devfinder.model.ids.DesafioHabilidadeId;
import br.com.devfinder.model.ids.DesafioId;
import br.com.devfinder.model.ids.TokenDesenvolvedorId;
import br.com.devfinder.model.ids.TokenEmpresaId;
import br.com.devfinder.repository.DesafioRepository;
import br.com.devfinder.repository.TokenDesenvolvedorRepository;
import br.com.devfinder.repository.TokenEmpresaRepository;

/**
 * @author Marlon Faria
 *
 */
@Service
public class TokenDesenvolvedorService {

	@Autowired
	private TokenDesenvolvedorRepository repository;
	
	/**
	 * Métodos POST
	 */
	public TokenDesenvolvedor saveToken(TokenDesenvolvedor token) {
		return repository.save(token);
	}


	/**
	 * Métodos GET
	 */
	
	public TokenDesenvolvedor getTokenDesenvolvedorById(TokenDesenvolvedorId id) {
		return repository.findById(id).orElse(null);
		
	}
	
	public TokenDesenvolvedor getTokenDesenvolvedorByToken(String token) {
		return repository.findByToken(token);
		
	}
	/**
	 * Método DELETE
	 */
	public void deleteToken(TokenDesenvolvedorId idToken) {
		repository.deleteById(idToken);
	}
	
	/**
	 * Método PUT
	 */
	public TokenDesenvolvedor updateToken(TokenDesenvolvedorId idToken) {
		TokenDesenvolvedor existingDesafio = repository.findById(idToken).orElse(null);
		existingDesafio.setAtivo(false);
		return repository.save(existingDesafio);
	}
}
