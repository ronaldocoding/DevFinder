package br.com.devfinder.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.devfinder.model.ids.DesenvolvedorHabilidadeId;

/**
 * @author Ronaldo Costa
 *
 */
@Entity
public class DesenvolvedorHabilidade {

	@EmbeddedId
	private DesenvolvedorHabilidadeId id;
	@ManyToOne
	private Desenvolvedor desenvolvedor;

	public DesenvolvedorHabilidade() {
	}

	public DesenvolvedorHabilidade(String emailDesenvolvedor, String habilidade) {
		id.setEmailDesenvolvedor(emailDesenvolvedor);
		id.setHabilidade(habilidade);
	}

	public String getEmailDesenvolvedor() {
		return id.getEmailDesenvolvedor();
	}

	public String getHabilidade() {
		return id.getHabilidade();
	}
}
