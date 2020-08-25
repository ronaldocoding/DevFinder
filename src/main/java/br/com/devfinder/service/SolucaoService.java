package br.com.devfinder.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devfinder.model.Solucao;
import br.com.devfinder.model.ids.SolucaoId;
import br.com.devfinder.repository.DesenvolvedorDesafioRepository;
import br.com.devfinder.repository.SolucaoRepository;

/**
 * @author Ronaldo Costa
 *
 */
@Service
public class SolucaoService {

	@Autowired
	private SolucaoRepository repository;

	@Autowired
	private DesenvolvedorDesafioRepository repositoryDD;

	/**
	 * Métodos POST
	 */
	public Solucao saveSolucao(Solucao solucao) {
		repositoryDD.update(solucao.getId().getEmailEmpresa(), solucao.getId().getEmailDesenvolvedor(), solucao.getId().getIdDesafio());
		return repository.save(solucao);
	}

	public List<Solucao> saveSolucoes(List<Solucao> solucoes) {
		return repository.saveAll(solucoes);
	}

	/**
	 * Métodos GET
	 */
	public List<Solucao> getSolucoesByDesafio(String emailEmpresa, int idDesafio) {
		return repository.findAllByDesafio(emailEmpresa, idDesafio);
	}
	
	public List<Solucao> getSolucoesByDesenvolvedor(String emailDesenvolvedor) {
		return repository.findAllByDesenvolvedor(emailDesenvolvedor);
	}

	public Solucao getSolucaoById(SolucaoId id) {
		return repository.findById(id).orElse(null);
	}

	/**
	 * Método DELETE
	 */
	public String deleteSolucao(SolucaoId id) {
		repository.deleteById(id);
		return "solucao deletada: " + id;
	}
	public void deleteSolucao(String emailDesenvolvedor) {
		repository.deleteAllByDesenvolvedor(emailDesenvolvedor);
	}

	public void deleteSolucaoByEmpresa(String emailEmpresa) {
		repository.deleteAllByEmpresa(emailEmpresa);
	}
	
	public List<Map<Integer, Integer>> findHistorico(String emailEmpresa) {
		return repository.findHistorico(emailEmpresa);
	}
}
