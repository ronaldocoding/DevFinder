package br.com.devfinder.model;

/**
 * @author Ronaldo Costa
 *
 */
public class Solucao {

	private String emailDesenvolvedor;
	private String emailEmpresa;
	private String idDesafio;
	private String nome;
	private String linkGithub;
	private String documentacao;
	private String descricao;

	public Solucao() {
	}

	public Solucao(String emailDesenvolvedor, String emailEmpresa, String idDesafio, String nome, String linkGithub,
			String documentacao, String descricao) {
		this.emailDesenvolvedor = emailDesenvolvedor;
		this.emailEmpresa = emailEmpresa;
		this.idDesafio = idDesafio;
		this.nome = nome;
		this.linkGithub = linkGithub;
		this.documentacao = documentacao;
		this.descricao = descricao;
	}

	public String getEmailDesenvolvedor() {
		return emailDesenvolvedor;
	}

	public String getEmailEmpresa() {
		return emailEmpresa;
	}

	public String getIdDesafio() {
		return idDesafio;
	}

	public String getNome() {
		return nome;
	}

	public String getLinkGithub() {
		return linkGithub;
	}

	public String getDocumentacao() {
		return documentacao;
	}

	public String getDescricao() {
		return descricao;
	}
}