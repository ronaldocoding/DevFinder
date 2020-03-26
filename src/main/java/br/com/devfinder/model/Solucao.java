package br.com.devfinder.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import br.com.devfinder.model.ids.SolucaoId;

/**
 * @author Ronaldo Costa
 *
 */
@Entity
public class Solucao {

	@EmbeddedId
	private SolucaoId id;
	@ManyToOne
	private Desenvolvedor desenvolvedor;
	@ManyToOne
	private Desafio desafio;
	private String nome;
	private String linkGithub;
	private String documentacao;
	private String descricao;

	public Solucao() {
	}

	public Solucao(String emailDesenvolvedor, String emailEmpresa, int idDesafio, String nome, String linkGithub,
			String documentacao, String descricao) {
		id.setEmailDesenvolvedor(emailDesenvolvedor);
		id.setEmailEmpresa(emailEmpresa);
		id.setIdDesafio(idDesafio);
		this.nome = nome;
		this.linkGithub = linkGithub;
		this.documentacao = documentacao;
		this.descricao = descricao;
	}

	public String getEmailDesenvolvedor() {
		return id.getEmailDesenvolvedor();
	}

	public String getEmailEmpresa() {
		return id.getEmailEmpresa();
	}

	public int getIdDesafio() {
		return id.getIdDesafio();
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
	
	public Desenvolvedor getDesenvolvedor() {
		return desenvolvedor;
	}
	
	public Desafio getDesafio() {
		return desafio;
	}
}
