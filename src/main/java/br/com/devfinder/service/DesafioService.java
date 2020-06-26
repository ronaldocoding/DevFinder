package br.com.devfinder.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.devfinder.model.Desafio;
import br.com.devfinder.model.DesafioHabilidade;
import br.com.devfinder.model.ids.DesafioHabilidadeId;
import br.com.devfinder.model.ids.DesafioId;
import br.com.devfinder.repository.DesafioRepository;

/**
 * @author Ronaldo Costa
 *
 */
@Service
public class DesafioService {

	@Autowired
	private DesafioRepository repository;
	
	@Autowired
	private DesafioHabilidadeService service;
	
	@Autowired
	private DesenvolvedorDesafioService serviceDD;
	
	/**
	 * Métodos POST
	 */
	public Desafio saveDesafio(Desafio desafio) {
		return repository.save(desafio);
	}

	public List<Desafio> saveDesafios(List<Desafio> desafios) {
		return repository.saveAll(desafios);
	}

	/**
	 * Métodos GET
	 */
	public List<Desafio> getDesafios(String emailEmpresa) {
		return repository.findAllByEmpresa(emailEmpresa);
	}
	public ArrayList<Desafio> getDesafios(String[] texto) {
		return (ArrayList<Desafio>) repository.findDesafio(texto);
	}
	
	public ArrayList<Desafio> getDesafiosInscritos(String email) {
		return (ArrayList<Desafio>) repository.findDesafioInscritos(email);
	}
	public Desafio getDesafioById(DesafioId id) {
		return repository.findById(id).orElse(null);
	}

	public Desafio getDesafioByNome(String nome) {
		return repository.findByNome(nome);

	}

	/**
	 * Método DELETE
	 */
	public String deleteDesafio(DesafioId id) {
		for(DesafioHabilidade d: service.getHabilidades(id.getEmailEmpresa(), id.getId())) {
			service.deleteHabilidade(
			new DesafioHabilidadeId(d.getEmailEmpresa(), d.getIdDesafio(), d.getHabilidade()));
		}
		repository.deleteById(id);
		return "desafio deletado: " + id;
	}
	
	public void deleteDesafio(String emailEmpresa) {
		repository.deleteAllByEmpresa(emailEmpresa);
	}
	
	/**
	 * Método PUT
	 */
	public Desafio updateDesafio(Desafio desafio) {
		DesafioId id = new DesafioId(desafio.getEmailEmpresa(), desafio.getId());
		Desafio existingDesafio = repository.findById(id).orElse(null);
		existingDesafio.setNome(desafio.getNome());
		existingDesafio.setDescricao(desafio.getDescricao());
		existingDesafio.setDataFim(desafio.getDataFim());
		existingDesafio.setHorarioFim(desafio.getHorarioFim());
		return repository.save(existingDesafio);
	}
}
