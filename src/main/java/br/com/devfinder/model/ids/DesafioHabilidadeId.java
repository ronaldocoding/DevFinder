package br.com.devfinder.model.ids;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Ronaldo Costa
 *
 */
@Embeddable
public class DesafioHabilidadeId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "EMAIL_EMPRESA_DESAFIO", nullable = false)
	private String emailEmpresa;
	
	@Column(name = "ID_DESAFIO", nullable = false)
	private int idDesafio;
	
	@Column(name = "HABILIDADE", nullable = false)
	private String habilidade;

	public DesafioHabilidadeId() {
	}

	public DesafioHabilidadeId(String emailEmpresa, int idDesafio, String habilidade) {
		this.emailEmpresa = emailEmpresa;
		this.idDesafio = idDesafio;
		this.habilidade = habilidade;
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

	public String getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(String habilidade) {
		this.habilidade = habilidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailEmpresa == null) ? 0 : emailEmpresa.hashCode());
		result = prime * result + ((habilidade == null) ? 0 : habilidade.hashCode());
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
		DesafioHabilidadeId other = (DesafioHabilidadeId) obj;
		if (emailEmpresa == null) {
			if (other.emailEmpresa != null)
				return false;
		} else if (!emailEmpresa.equals(other.emailEmpresa))
			return false;
		if (habilidade == null) {
			if (other.habilidade != null)
				return false;
		} else if (!habilidade.equals(other.habilidade))
			return false;
		if (idDesafio != other.idDesafio)
			return false;
		return true;
	}
}
