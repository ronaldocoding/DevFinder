package br.com.devfinder.model.ids;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Ronaldo Costa
 *
 */
@Embeddable
public class DesenvolvedorHabilidadeId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "EMAIL_DESENVOLVEDOR", length = 55, nullable = false)
	private String emailDesenvolvedor;
	
	@Column(name = "HABILIDADE", length = 55, nullable = false)
	private String habilidade;

	public DesenvolvedorHabilidadeId() {
	}

	public DesenvolvedorHabilidadeId(String emailDesenvolvedor, String habilidade) {
		this.emailDesenvolvedor = emailDesenvolvedor;
		this.habilidade = habilidade;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailDesenvolvedor == null) ? 0 : emailDesenvolvedor.hashCode());
		result = prime * result + ((habilidade == null) ? 0 : habilidade.hashCode());
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
		DesenvolvedorHabilidadeId other = (DesenvolvedorHabilidadeId) obj;
		if (emailDesenvolvedor == null) {
			if (other.emailDesenvolvedor != null)
				return false;
		} else if (!emailDesenvolvedor.equals(other.emailDesenvolvedor))
			return false;
		if (habilidade == null) {
			if (other.habilidade != null)
				return false;
		} else if (!habilidade.equals(other.habilidade))
			return false;
		return true;
	}
}
