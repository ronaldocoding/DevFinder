package br.com.devfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devfinder.model.DesenvolvedorAreaAtuacao;
import br.com.devfinder.model.ids.DesenvolvedorAreaAtuacaoId;
import br.com.devfinder.repository.DesenvolvedorAreaAtuacaoRepository;

/**
 * @author Ronaldo Costa
 *
 */
@Service
public class DesenvolvedorAreaAtuacaoService {

	@Autowired
	private DesenvolvedorAreaAtuacaoRepository repository;

	/**
	 * Métodos POST
	 */
	public DesenvolvedorAreaAtuacao saveArea(DesenvolvedorAreaAtuacao area) {
		return repository.save(area);
	}

	public List<DesenvolvedorAreaAtuacao> saveAreas(List<DesenvolvedorAreaAtuacao> areas) {
		return repository.saveAll(areas);
	}

	/**
	 * Métodos GET
	 */
	public List<DesenvolvedorAreaAtuacao> getAreas(String emailDesenvolvedor) {
		return repository.findAllByDesenvolvedor(emailDesenvolvedor);
	}

	public DesenvolvedorAreaAtuacao getAreaById(DesenvolvedorAreaAtuacaoId id) {
		return repository.findById(id).orElse(null);
	}

	/**
	 * Método DELETE
	 */
	public String deleteArea(DesenvolvedorAreaAtuacaoId id) {
		repository.deleteById(id);
		return "desenvolvedorAreaAtuacao deletada: " + id;
	}
	
	public void deleteArea(String emailDesenvolvedor) {
		repository.deleteAllByDesenvolvedor(emailDesenvolvedor);
	}
}
