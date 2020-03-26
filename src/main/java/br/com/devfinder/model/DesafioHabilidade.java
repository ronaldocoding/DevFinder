package br.com.devfinder.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.devfinder.model.ids.DesafioHabilidadeId;

/**
 * @author Ronaldo Costa
 *
 */
@Entity
public class DesafioHabilidade {

	@EmbeddedId
	private DesafioHabilidadeId id;
	@ManyToOne
	private Desafio desafio;

	public DesafioHabilidade() {
	}

	public DesafioHabilidade(String emailEmpresa, int idDesafio, String habilidade) {
		id.setEmailEmpresa(emailEmpresa);
		id.setIdDesafio(idDesafio);
		id.setHabilidade(habilidade);
	}

	public String getEmailEmpresa() {
		return id.getEmailEmpresa();
	}

	public int getIdDesafio() {
		return id.getIdDesafio();
	}

	public String getHabilidade() {
		return id.getHabilidade();
	}

	public Desafio getDesafio() {
		return desafio;
	}

}
