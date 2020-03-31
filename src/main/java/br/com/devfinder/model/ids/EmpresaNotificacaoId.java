package br.com.devfinder.model.ids;

import java.io.Serializable;

/**
 * @author Ronaldo Costa
 *
 */
public class EmpresaNotificacaoId implements Serializable {

	private static final long serialVersionUID = 1L;
	private String emailEmpresa;
	private int id;
	private String titulo;

	public EmpresaNotificacaoId() {
	}

	public EmpresaNotificacaoId(String emailEmpresa, int id, String titulo) {
		this.emailEmpresa = emailEmpresa;
		this.id = id;
		this.titulo = titulo;
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailEmpresa == null) ? 0 : emailEmpresa.hashCode());
		result = prime * result + id;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		EmpresaNotificacaoId other = (EmpresaNotificacaoId) obj;
		if (emailEmpresa == null) {
			if (other.emailEmpresa != null)
				return false;
		} else if (!emailEmpresa.equals(other.emailEmpresa))
			return false;
		if (id != other.id)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
}
