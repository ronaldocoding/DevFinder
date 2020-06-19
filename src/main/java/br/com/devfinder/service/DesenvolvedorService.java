package br.com.devfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devfinder.model.Desenvolvedor;
import br.com.devfinder.repository.DesenvolvedorRepository;

/**
 * @author Ronaldo Costa
 *
 */
@Service
public class DesenvolvedorService {

	@Autowired
	private DesenvolvedorRepository repository;

	/**
	 * Métodos POST
	 */
	public Desenvolvedor saveDesenvolvedor(Desenvolvedor desenvolvedor) {
		return repository.save(desenvolvedor);
	}

	public List<Desenvolvedor> saveDesenvolvedores(List<Desenvolvedor> desenvolvedores) {
		return repository.saveAll(desenvolvedores);
	}

	/**
	 * Métodos GET
	 */
	public List<Desenvolvedor> getDesenvolvedores() {
		return repository.findAll();
	}
	public List<Desenvolvedor> getDesenvolvedores(String[] texto) {
		return repository.findDesenvolvedor(texto);
	}
	public Desenvolvedor getDesenvolvedorById(String email) {
		return repository.findById(email).orElse(null);
	}

	public Desenvolvedor getDesenvolvedorByNome(String nome) {
		return repository.findByNome(nome);
	}

	/**
	 * Método DELETE
	 */
	public String deleteDesenvolvedor(String email) {
		repository.deleteById(email);
		return "desenvolvedor deletado: " + email;
	}

	/**
	 * Método PUT
	 */
	public Desenvolvedor updateDesenvolvedor(Desenvolvedor desenvolvedor) {
		Desenvolvedor existingDesenvolvedor = repository.findById(desenvolvedor.getEmail()).orElse(null);
		existingDesenvolvedor.setFoto(desenvolvedor.getFoto());
		existingDesenvolvedor.setSenha(desenvolvedor.getSenha());
		existingDesenvolvedor.setEndereco(desenvolvedor.getEndereco());
		existingDesenvolvedor.setSite(desenvolvedor.getSite());
		existingDesenvolvedor.setTelefone(desenvolvedor.getTelefone());
		existingDesenvolvedor.setApresentacao(desenvolvedor.getApresentacao());
		existingDesenvolvedor.setTempoExperiencia(desenvolvedor.getTempoExperiencia());
		existingDesenvolvedor.setLinkedIn(desenvolvedor.getLinkedIn());
		existingDesenvolvedor.setGitHub(desenvolvedor.getGitHub());
		existingDesenvolvedor.setCurriculo(desenvolvedor.getCurriculo());
		return repository.save(existingDesenvolvedor);
	}
}
