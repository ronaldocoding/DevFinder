package br.com.devfinder.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.devfinder.model.ids.DesafioHabilidadeId;
import br.com.devfinder.model.ids.TokenDesenvolvedorId;
import br.com.devfinder.model.ids.TokenEmpresaId;

/**
 * @author Marlon Faria
 *
 */
@Entity
@Table(name = "DESENVOLVEDOR_TOKEN")
public class TokenDesenvolvedor implements Serializable {

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private TokenDesenvolvedorId id = new TokenDesenvolvedorId();
	
	@Column(name = "ativo", nullable = false)
	private boolean ativo;

	@Column(name = "token", length = 55, unique=true)
	private String token;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMAIL_DESENVOLVEDOR", referencedColumnName = "EMAIL", nullable = false, insertable = false, updatable = false)
	private Desenvolvedor desenvolvedor;

	public TokenDesenvolvedor() {
	}

	public TokenDesenvolvedor(String emailDesenvolvedor, boolean ativo, String token) {
		this.id.setEmailDesenvolvedor(emailDesenvolvedor);
		this.ativo = ativo;
		this.token = token;
	}
	
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Desenvolvedor getDesenvolvedor() {
		return desenvolvedor;
	}

	public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}



	
}
