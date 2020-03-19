package br.com.devfinder.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Ronaldo Costa
 *
 */
@Entity
public class DesafioHabilidade {

	@Id
	private String emailEmpresa;
	@Id
	private int idDesafio;
	@Id
	private String habilidade;

	public DesafioHabilidade() {
	}

	public DesafioHabilidade(String emailEmpresa, int idDesafio, String habilidade) {
		this.emailEmpresa = emailEmpresa;
		this.idDesafio = idDesafio;
		this.habilidade = habilidade;
	}

	public String getEmailEmpresa() {
		return emailEmpresa;
	}

	public int getIdDesafio() {
		return idDesafio;
	}

	public String getHabilidade() {
		return habilidade;
	}

}
