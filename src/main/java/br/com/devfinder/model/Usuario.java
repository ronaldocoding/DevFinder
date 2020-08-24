package br.com.devfinder.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * @author Ronaldo Costa
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EMAIL", unique=true,columnDefinition="VARCHAR(64)")
	protected String email;
	
    @Column(name = "FOTO",columnDefinition = "LONGBLOB",  nullable = true)
    private byte[] foto;

	@Column(name = "SENHA", nullable = false)
	protected String senha;

	@Embedded
	protected Endereco endereco;

	@Column(name = "SITE", nullable = true)
	protected String site;

	@Column(name = "TELEFONE", length = 18, nullable = false)
	protected String telefone;

	@Column(name = "APRESENTACAO", nullable = false)
	protected String apresentacao;

	public Usuario() {
	}

	public Usuario(String email, byte[] foto, String senha, Endereco endereco, String site, String telefone,
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

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
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
