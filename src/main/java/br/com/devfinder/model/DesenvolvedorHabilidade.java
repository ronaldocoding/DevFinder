package br.com.devfinder.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Ronaldo Costa
 *
 */
@Entity
public class DesenvolvedorHabilidade {

	@Id
	private String emailDesenvolvedor;
	@Id
	private String habilidade;

	public DesenvolvedorHabilidade() {
	}

	public DesenvolvedorHabilidade(String emailDesenvolvedor, String habilidade) {
		this.emailDesenvolvedor = emailDesenvolvedor;
		this.habilidade = habilidade;
	}

	public String getEmailDesenvolvedor() {
		return emailDesenvolvedor;
	}

	public String getHabilidade() {
		return habilidade;
	}
}
