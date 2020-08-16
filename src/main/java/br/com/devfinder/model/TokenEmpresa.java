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
import br.com.devfinder.model.ids.TokenEmpresaId;

/**
 * @author Marlon Faria
 *
 */
@Entity
@Table(name = "EMPRESA_TOKEN")
public class TokenEmpresa implements Serializable {

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	private TokenEmpresaId id = new TokenEmpresaId();
	
	@Column(name = "ativo", nullable = false)
	private boolean ativo;

	@Column(name = "token", length = 55, unique=true)
	private String token;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMAIL_EMPRESA", referencedColumnName = "EMAIL", nullable = false, insertable = false, updatable = false)
	private Empresa empresa;

	public TokenEmpresa() {
	}

	public TokenEmpresa(String emailEmpresa, boolean ativo, String token) {
		this.id.setEmailEmpresa(emailEmpresa);
		this.ativo = ativo;
		this.token = token;
	}
	
	
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}



	
}
