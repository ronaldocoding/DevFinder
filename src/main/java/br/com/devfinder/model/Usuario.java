package br.com.devfinder.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author Ronaldo Costa
 *
 */
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Usuario {

	@Id
	protected String email;
	@Column(nullable=true)
	protected String foto;
	protected String senha;
	@Embedded
	protected Endereco endereco;
	@Column(nullable=true)
	protected String site;
	@Column(nullable=true)
	protected String telefone;
	protected String apresentacao;

	public Usuario() {
	}

	public Usuario(String email, String foto, String senha, Endereco endereco, String site, String telefone,
			String apresentacao) {
		this.email = email;
		this.foto = foto;
		this.senha = senha;
		this.endereco = endereco;
		this.site = site;
		this.telefone = telefone;
		this.apresentacao = apresentacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getApresentacao() {
		return apresentacao;
	}

	public void setApresentacao(String apresentacao) {
		this.apresentacao = apresentacao;
	}
}
