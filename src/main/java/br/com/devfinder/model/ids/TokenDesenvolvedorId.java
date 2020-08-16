package br.com.devfinder.model.ids;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Marlon Faria
 *
 */
@Embeddable
public class TokenDesenvolvedorId implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "EMAIL_DESENVOLVEDOR", length = 55, nullable = false)
	private String emailDesenvolvedor;
	
	public TokenDesenvolvedorId() {
	}

	public TokenDesenvolvedorId(String emailDesenvolvedor) {
		this.emailDesenvolvedor = emailDesenvolvedor;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailDesenvolvedor == null) ? 0 : emailDesenvolvedor.hashCode());
		//result = prime * result + id;
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
		TokenDesenvolvedorId other = (TokenDesenvolvedorId) obj;
		if (emailDesenvolvedor == null) {
			if (other.emailDesenvolvedor != null)
				return false;
		} else if (!emailDesenvolvedor.equals(other.emailDesenvolvedor))
			return false;
		/*if (id != other.id)
			return false;
		*/
		return true;
	}

	public String getEmailDesenvolvedor() {
		return emailDesenvolvedor;
	}

	public void setEmailDesenvolvedor(String emailDesenvolvedor) {
		this.emailDesenvolvedor = emailDesenvolvedor;
	}
}
