package br.com.devfinder.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.devfinder.model.Desafio;
import br.com.devfinder.model.ids.DesafioId;
import br.com.devfinder.repository.DesafioRepository;

/**
 * @author Ronaldo Costa
 *
 */
@Service
public class DesafioService {

	private DesafioRepository repository;
	
	/**
	 * Métodos POST
	 * */
	public Desafio saveDesafio(Desafio desafio) {
		return repository.save(desafio);
	}
	
	public List<Desafio> saveDesafios(List<Desafio> desafios) {
		return repository.saveAll(desafios);
	}
	
	/**
	 * Métodos GET
	 * */
	public List<Desafio> getDesafios() {
		return repository.findAll();
	}
	
	public Desafio getDesafioById(DesafioId id) {
		return repository.findById(id).orElse(null);
	}
	
	public Desafio getDesafioByNome(String nome) {
		return repository.findByNome(nome);
		
	}
	
	/**
	 * Método DELETE
	 * */
	public String deleteDesafio(DesafioId id) {
		repository.deleteById(id);
		return "desafio deletado: " + id;
	}
	
	/**
	 * Método PUT
	 * */
	public Desafio updateDesafio(Desafio desafio) {
		DesafioId id = new DesafioId();
		id.setEmailEmpresa(desafio.getEmailEmpresa());
		id.setIdDesafio(desafio.getId());
		Desafio existingDesafio = repository.findById(id).orElse(null);
		existingDesafio.setNome(desafio.getNome());
		existingDesafio.setDescricao(desafio.getDescricao());
		existingDesafio.setDataHoraFim(desafio.getDataHoraFim());
		return repository.save(existingDesafio);
	}
	
}
