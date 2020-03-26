package br.com.devfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devfinder.model.DesenvolvedorHabilidade;
import br.com.devfinder.model.ids.DesenvolvedorHabilidadeId;
import br.com.devfinder.repository.DesenvolvedorHabilidadeRepository;

/**
 * @author Ronaldo Costa
 *
 */
@Service
public class DesenvolvedorHabilidadeService {

	@Autowired
	private DesenvolvedorHabilidadeRepository repository;

	/**
	 * Métodos POST
	 * */
	public DesenvolvedorHabilidade saveHabilidade(DesenvolvedorHabilidade habilidade) {
		return repository.save(habilidade);
	}
	
	public List<DesenvolvedorHabilidade> saveHabilidades(List<DesenvolvedorHabilidade> habilidades) {
		return repository.saveAll(habilidades);
	}
	
	/**
	 * Métodos GET
	 * */
	public List<DesenvolvedorHabilidade> getHabilidades() {
		return repository.findAll();
	}
	
	public DesenvolvedorHabilidade getHabilidadeById(DesenvolvedorHabilidadeId id) {
		return repository.findById(id).orElse(null);
	}
	
	/**
	 * Método DELETE
	 * */
	public String deleteHabilidade(DesenvolvedorHabilidadeId id) {
		repository.deleteById(id);
		return "desenvolvedorHabilidade deletada: " + id;
	}
}
