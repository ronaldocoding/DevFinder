package br.com.devfinder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devfinder.model.Desafio;
import br.com.devfinder.model.DesenvolvedorDesafio;
import br.com.devfinder.model.ids.DesenvolvedorDesafioId;
import br.com.devfinder.repository.DesenvolvedorDesafioRepository;

/**
 * @author Ronaldo Costa
 *
 */
@Service
public class DesenvolvedorDesafioService {

	@Autowired
	private DesenvolvedorDesafioRepository repository;
	
	/**
	 * Métodos POST
	 */
	public DesenvolvedorDesafio saveInscricao(DesenvolvedorDesafio inscricao) {
		return repository.save(inscricao);
	}

	public List<DesenvolvedorDesafio> saveInscricoes(List<DesenvolvedorDesafio> inscricoes) {
		return repository.saveAll(inscricoes);
	}

	/**
	 * Métodos GET
	 */
	public List<DesenvolvedorDesafio> getInscricoes(String emailEmpresa, int idDesafio) {
		return repository.findAllByDesafio(emailEmpresa, idDesafio);
	}
	
	public DesenvolvedorDesafio getInscricaoById(String emaildev, String emailEmp, int idDesafio) {
		return repository.findById(new DesenvolvedorDesafioId(emaildev, emailEmp, idDesafio)).orElse(null);
	}
	
	public DesenvolvedorDesafio getInscricaoById(DesenvolvedorDesafioId id) {
		return repository.findById(id).orElse(null);
	}
	/**
	 * Método DELETE
	 */
	public String deleteInscricao(DesenvolvedorDesafioId id) {
		repository.deleteById(id);
		return "desafioHabilidade deletada: " + id;
	}
}
