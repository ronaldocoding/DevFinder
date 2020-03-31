package br.com.devfinder.model.ids;

import java.io.Serializable;

/**
 * @author Ronaldo Costa
 *
 */
public class DesenvolvedorNotificacaoId implements Serializable {

	private static final long serialVersionUID = 1L;
	private String emailDesenvolvedor;
	private int id;
	private String titulo;

	public DesenvolvedorNotificacaoId() {
	}

	public DesenvolvedorNotificacaoId(String emailDesenvolvedor, int id, String titulo) {
		this.emailDesenvolvedor = emailDesenvolvedor;
		this.id = id;
		this.titulo = titulo;
	}

	public String getEmailDesenvolvedor() {
		return emailDesenvolvedor;
	}

	public void setEmailDesenvolvedor(String emailDesenvolvedor) {
		this.emailDesenvolvedor = emailDesenvolvedor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
		result = prime * result + ((emailDesenvolvedor == null) ? 0 : emailDesenvolvedor.hashCode());
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
		DesenvolvedorNotificacaoId other = (DesenvolvedorNotificacaoId) obj;
		if (emailDesenvolvedor == null) {
			if (other.emailDesenvolvedor != null)
				return false;
		} else if (!emailDesenvolvedor.equals(other.emailDesenvolvedor))
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
