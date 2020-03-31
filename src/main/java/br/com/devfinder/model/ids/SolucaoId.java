package br.com.devfinder.model.ids;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Ronaldo Costa
 *
 */
@Embeddable
public class SolucaoId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "EMAIL_DESENVOLVEDOR", nullable = false)
	private String emailDesenvolvedor;
	
	@Column(name = "EMAIL_EMPRESA_DESAFIO", nullable = false)
	private String emailEmpresa;
	
	@Column(name = "ID_DESAFIO" , nullable = false)
	private int idDesafio;

	public SolucaoId() {
	}

	public SolucaoId(String emailDesenvolvedor, String emailEmpresa, int idDesafio) {
		this.emailDesenvolvedor = emailDesenvolvedor;
		this.emailEmpresa = emailEmpresa;
		this.idDesafio = idDesafio;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailDesenvolvedor == null) ? 0 : emailDesenvolvedor.hashCode());
		result = prime * result + ((emailEmpresa == null) ? 0 : emailEmpresa.hashCode());
		result = prime * result + idDesafio;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SolucaoId other = (SolucaoId) obj;
		if (emailDesenvolvedor == null) {
			if (other.emailDesenvolvedor != null)
				return false;
		} else if (!emailDesenvolvedor.equals(other.emailDesenvolvedor))
			return false;
		if (emailEmpresa == null) {
			if (other.emailEmpresa != null)
				return false;
		} else if (!emailEmpresa.equals(other.emailEmpresa))
			return false;
		if (idDesafio != other.idDesafio)
			return false;
		return true;
	}
}
