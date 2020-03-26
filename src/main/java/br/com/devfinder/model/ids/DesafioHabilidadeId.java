package br.com.devfinder.model.ids;

import javax.persistence.Embeddable;

/**
 * @author Ronaldo Costa
 *
 */
@Embeddable
public class DesafioHabilidadeId {

	private String emailEmpresa;
	private int idDesafio;
	private String habilidade;

	public String getEmailEmpresa() {
		return emailEmpresa;
	}

	public void setEmailEmpresa(String emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}

	public int getIdDesafio() {
		return idDesafio;
	}

	public void setIdDesafio(int idDesafio) {
		this.idDesafio = idDesafio;
	}

	public String getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(String habilidade) {
		this.habilidade = habilidade;
	}
}
