package br.com.devfinder.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.devfinder.model.ids.DesenvolvedorAreaAtuacaoId;

/**
 * @author Ronaldo Costa
 *
 */
@Entity
@Table(name = "DESENVOLVEDOR_AREA_ATUACAO")
public class DesenvolvedorAreaAtuacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DesenvolvedorAreaAtuacaoId id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "EMAIL_DESENVOLVEDOR", referencedColumnName = "EMAIL", nullable = false, insertable = false, updatable = false)
	private Desenvolvedor desenvolvedor;

	public DesenvolvedorAreaAtuacao() {
	}

	public DesenvolvedorAreaAtuacao(String emailDesenvolvedor, String areaAtuacao) {
		id.setEmailDesenvolvedor(emailDesenvolvedor);
		id.setAreaAtuacao(areaAtuacao);
	}

	public String getEmailDesenvolvedor() {
		return id.getEmailDesenvolvedor();
	}
	
	public void setEmailDesenvolvedor(String emailDesenvolvedor) {
		id.setEmailDesenvolvedor(emailDesenvolvedor);
	}

	public String getAreaAtuacao() {
		return id.getAreaAtuacao();
	}
	
	public void setAreaAtuacao(String areaAtuacao) {
		id.setAreaAtuacao(areaAtuacao);
	}

	public Desenvolvedor getDesenvolvedor() {
		return desenvolvedor;
	}
	
	public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}
}
