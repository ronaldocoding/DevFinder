package br.com.devfinder.model.ids;

import javax.persistence.Embeddable;

/**
 * @author Ronaldo Costa
 *
 */
@Embeddable
public class SolucaoId {

	private String emailDesenvolvedor;
	private String emailEmpresa;
	private int idDesafio;

	public String getEmailDesenvolvedor() {
		return emailDesenvolvedor;
	}

	public void setEmailDesenvolvedor(String emailDesenvolvedor) {
		this.emailDesenvolvedor = emailDesenvolvedor;
	}

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
}
