package br.com.devfinder.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Ronaldo Costa
 *
 */
@Entity
public class DesenvolvedorAreaAtuacao {

	@Id
	private String emailDesenvolvedor;
	@Id
	private String areaAtuacao;

	public DesenvolvedorAreaAtuacao() {
	}

	public DesenvolvedorAreaAtuacao(String emailDesenvolvedor, String areaAtuacao) {
		this.emailDesenvolvedor = emailDesenvolvedor;
		this.areaAtuacao = areaAtuacao;
	}

	public String getEmailDesenvolvedor() {
		return emailDesenvolvedor;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}
}
