package br.com.devfinder.model.ids;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Marlon Faria
 *
 */
@Embeddable
public class TokenEmpresaId implements Serializable {

	private static final long serialVersionUID = 1L;
	@Column(name = "EMAIL_EMPRESA", length = 55, nullable = false)
	private String emailEmpresa;
	
	public TokenEmpresaId() {
	}

	public TokenEmpresaId(String emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}

	public String getEmailEmpresa() {
		return emailEmpresa;
	}

	public void setEmailEmpresa(String emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailEmpresa == null) ? 0 : emailEmpresa.hashCode());
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
		TokenEmpresaId other = (TokenEmpresaId) obj;
		if (emailEmpresa == null) {
			if (other.emailEmpresa != null)
				return false;
		} else if (!emailEmpresa.equals(other.emailEmpresa))
			return false;
		/*if (id != other.id)
			return false;
		*/
		return true;
	}
}
