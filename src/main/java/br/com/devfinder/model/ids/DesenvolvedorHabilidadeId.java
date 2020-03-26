package br.com.devfinder.model.ids;

import javax.persistence.Embeddable;

/**
 * @author Ronaldo Costa
 *
 */
@Embeddable
public class DesenvolvedorHabilidadeId {

	private String emailDesenvolvedor;
	private String habilidade;

	public String getEmailDesenvolvedor() {
		return emailDesenvolvedor;
	}

	public void setEmailDesenvolvedor(String emailDesenvolvedor) {
		this.emailDesenvolvedor = emailDesenvolvedor;
	}

	public String getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(String habilidade) {
		this.habilidade = habilidade;
	}
}
