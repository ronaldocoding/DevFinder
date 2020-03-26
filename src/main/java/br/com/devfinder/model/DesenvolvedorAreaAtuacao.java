package br.com.devfinder.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.devfinder.model.ids.DesenvolvedorAreaAtuacaoId;

/**
 * @author Ronaldo Costa
 *
 */
@Entity
public class DesenvolvedorAreaAtuacao {

	@EmbeddedId
	private DesenvolvedorAreaAtuacaoId id;
	@ManyToOne
	private Desenvolvedor desenvolvedor;
	
	public DesenvolvedorAreaAtuacao() {
	}

	public DesenvolvedorAreaAtuacao(String emailDesenvolvedor, String areaAtuacao) {
		id.setEmailDesenvolvedor(emailDesenvolvedor);
		id.setAreaAtuacao(areaAtuacao);
	}

	public String getEmailDesenvolvedor() {
		return id.getEmailDesenvolvedor();
	}
	
	public String getAreaAtuacao() {
		return id.getAreaAtuacao();
	}
	
	public Desenvolvedor getDesenvolvedor() {
		return desenvolvedor;
	}
}
