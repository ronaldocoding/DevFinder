package br.com.devfinder.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.devfinder.model.ids.DesenvolvedorHabilidadeId;

/**
 * @author Ronaldo Costa
 *
 */
@Entity
@Table(name = "DESENVOLVEDOR_HABILIDADE")
public class DesenvolvedorHabilidade implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DesenvolvedorHabilidadeId id;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "EMAIL_DESENVOLVEDOR", referencedColumnName = "EMAIL", nullable = false, insertable = false, updatable = false)
	private Desenvolvedor desenvolvedor;

	public DesenvolvedorHabilidade() {
	}

	public DesenvolvedorHabilidade(String emailDesenvolvedor, String habilidade) {
		id.setEmailDesenvolvedor(emailDesenvolvedor);
		id.setHabilidade(habilidade);
	}

	public String getEmailDesenvolvedor() {
		return id.getEmailDesenvolvedor();
	}

	public void setEmailDesenvolvedor(String emailDesenvolvedor) {
		id.setEmailDesenvolvedor(emailDesenvolvedor);
	}

	public String getHabilidade() {
		return id.getHabilidade();
	}

	public void setHabilidade(String habilidade) {
		id.setHabilidade(habilidade);
	}

	public Desenvolvedor getDesenvolvedor() {
		return desenvolvedor;
	}

	public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}
}
