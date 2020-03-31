package br.com.devfinder.model.ids;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Ronaldo Costa
 *
 */
@Embeddable
public class DesenvolvedorAreaAtuacaoId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "EMAIL_DESENVOLVEDOR", nullable = false)
	private String emailDesenvolvedor;
	
	@Column(name = "AREA_ATUACAO", nullable = false)
	private String areaAtuacao;

	public DesenvolvedorAreaAtuacaoId() {
	}

	public DesenvolvedorAreaAtuacaoId(String emailDesenvolvedor, String areaAtuacao) {
		this.emailDesenvolvedor = emailDesenvolvedor;
		this.areaAtuacao = areaAtuacao;
	}

	public String getEmailDesenvolvedor() {
		return emailDesenvolvedor;
	}

	public void setEmailDesenvolvedor(String emailDesenvolvedor) {
		this.emailDesenvolvedor = emailDesenvolvedor;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}

	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((areaAtuacao == null) ? 0 : areaAtuacao.hashCode());
		result = prime * result + ((emailDesenvolvedor == null) ? 0 : emailDesenvolvedor.hashCode());
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
		DesenvolvedorAreaAtuacaoId other = (DesenvolvedorAreaAtuacaoId) obj;
		if (areaAtuacao == null) {
			if (other.areaAtuacao != null)
				return false;
		} else if (!areaAtuacao.equals(other.areaAtuacao))
			return false;
		if (emailDesenvolvedor == null) {
			if (other.emailDesenvolvedor != null)
				return false;
		} else if (!emailDesenvolvedor.equals(other.emailDesenvolvedor))
			return false;
		return true;
	}
}
