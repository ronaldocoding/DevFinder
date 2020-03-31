package br.com.devfinder.model.ids;

import java.io.Serializable;

/**
 * @author Ronaldo Costa
 *
 */
public class DesafioId implements Serializable {

	private static final long serialVersionUID = 1L;
	private String emailEmpresa;
	private int id;

	public DesafioId() {
	}

	public DesafioId(String emailEmpresa, int id) {
		this.emailEmpresa = emailEmpresa;
		this.id = id;
	}

	public String getEmailEmpresa() {
		return emailEmpresa;
	}

	public void setEmailEmpresa(String emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailEmpresa == null) ? 0 : emailEmpresa.hashCode());
		result = prime * result + id;
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
		DesafioId other = (DesafioId) obj;
		if (emailEmpresa == null) {
			if (other.emailEmpresa != null)
				return false;
		} else if (!emailEmpresa.equals(other.emailEmpresa))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
}
