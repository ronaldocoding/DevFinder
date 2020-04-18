package br.com.devfinder.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.devfinder.model.ids.DesafioHabilidadeId;

/**
 * @author Ronaldo Costa
 *
 */
@Entity
@Table(name = "DESAFIO_HABILIDADE")
public class DesafioHabilidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DesafioHabilidadeId id = new DesafioHabilidadeId();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns({
			@JoinColumn(name = "EMAIL_EMPRESA_DESAFIO", referencedColumnName = "EMAIL_EMPRESA", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "ID_DESAFIO", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false) })
	private Desafio desafio;

	public DesafioHabilidade() {
	}

	public DesafioHabilidade(String emailEmpresa, int idDesafio, String habilidade) {
		id.setEmailEmpresa(emailEmpresa);
		id.setIdDesafio(idDesafio);
		id.setHabilidade(habilidade);
	}

	public String getEmailEmpresa() {
		return id.getEmailEmpresa();
	}

	public void setEmailEmpresa(String emailEmpresa) {
		id.setEmailEmpresa(emailEmpresa);
	}

	public int getIdDesafio() {
		return id.getIdDesafio();
	}

	public void setIdDesafio(int idDesafio) {
		id.setIdDesafio(idDesafio);
	}

	public String getHabilidade() {
		return id.getHabilidade();
	}

	public void setHabilidade(String habilidade) {
		id.setHabilidade(habilidade);
	}

	public Desafio getDesafio() {
		return desafio;
	}

	public void setDesafio(Desafio desafio) {
		this.desafio = desafio;
	}
}
