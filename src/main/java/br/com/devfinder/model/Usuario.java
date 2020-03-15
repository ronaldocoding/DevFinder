package br.com.devfinder.model;

/**
 * @author Ronaldo Costa
 *
 */
public abstract class Usuario {

	protected String email;
	protected String foto;
	protected String senha;
	protected Endereco endereco;
	protected String site;
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
