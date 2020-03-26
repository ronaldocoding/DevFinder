package br.com.devfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devfinder.model.DesafioHabilidade;
import br.com.devfinder.model.ids.DesafioHabilidadeId;
import br.com.devfinder.repository.DesafioHabilidadeRepository;


/**
 * @author Ronaldo Costa
 *
 */
@Service
public class DesafioHabilidadeService {

	@Autowired
	private DesafioHabilidadeRepository repository;
	
	/**
	 * Métodos POST
	 * */
	public DesafioHabilidade saveHabilidade(DesafioHabilidade habilidade) {
		return repository.save(habilidade);
	}
	
	public List<DesafioHabilidade> saveHabilidades(List<DesafioHabilidade> habilidades) {
		return repository.saveAll(habilidades);
	}
	
	/**
	 * Métodos GET
	 * */
	public List<DesafioHabilidade> getHabilidades() {
		return repository.findAll();
	}
	
	public DesafioHabilidade getHabilidadeById(DesafioHabilidadeId id) {
		return repository.findById(id).orElse(null);
	}
	
	/**
	 * Método DELETE
	 * */
	public String deleteHabilidade(DesafioHabilidadeId id) {
		repository.deleteById(id);
		return "desafioHabilidade deletada: " + id;
	}
}
