package br.com.devfinder.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.devfinder.model.ids.SolucaoId;

/**
 * @author Ronaldo Costa
 *
 */
@Entity
@Table(name = "SOLUCAO")
public class Solucao implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SolucaoId id;

	@Column(name = "NOME", length = 55, nullable = false)
	private String nome;

	@Column(name = "LINK_GITHUB", nullable = false)
	private String linkGithub;

	@Column(name = "DESCRICAO", nullable = false)
	private String descricao;

	@Column(name = "DATA_ENVIO", length = 11, nullable = false)
	private String dataEnvio;

	@Column(name = "HORARIO_ENVIO", length = 5, nullable = false)
	private String horarioEnvio;

    @Column(name = "documentacao", columnDefinition="BLOB")
    private Blob documentacao;
    
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "EMAIL_DESENVOLVEDOR", referencedColumnName = "EMAIL", nullable = false, insertable = false, updatable = false)
	private Desenvolvedor desenvolvedor;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumns(value = {
			@JoinColumn(name = "EMAIL_EMPRESA_DESAFIO", referencedColumnName = "EMAIL_EMPRESA", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "ID_DESAFIO", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false) })
	private Desafio desafio;

	public Solucao() {
	}

	public Solucao(String emailDesenvolvedor, String emailEmpresa, int idDesafio, String linkGithub,
			Blob documentacao, String descricao, String dataEnvio, String horarioEnvio) {
		id.setEmailDesenvolvedor(emailDesenvolvedor);
		id.setEmailEmpresa(emailEmpresa);
		id.setIdDesafio(idDesafio);
		this.nome = "eoq";
		this.linkGithub = linkGithub;
		this.documentacao = documentacao;
		this.descricao = descricao;
		this.dataEnvio = dataEnvio;
		this.horarioEnvio = horarioEnvio;
	}

	public SolucaoId getId() {
		return id;
	}

	public void setId(SolucaoId id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLinkGithub() {
		return linkGithub;
	}

	public void setLinkGithub(String linkGithub) {
		this.linkGithub = linkGithub;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Blob getDocumentacao() {
		return documentacao;
	}

	public void setDocumentacao(Blob documentacao) {
		this.documentacao = documentacao;
	}

	public String getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(String dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public String getHorarioEnvio() {
		return horarioEnvio;
	}

	public void setHorarioEnvio(String horarioEnvio) {
		this.horarioEnvio = horarioEnvio;
	}

	public Desenvolvedor getDesenvolvedor() {
		return desenvolvedor;
	}

	public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}

	public Desafio getDesafio() {
		return desafio;
	}

	public void setDesafio(Desafio desafio) {
		this.desafio = desafio;
	}
}
