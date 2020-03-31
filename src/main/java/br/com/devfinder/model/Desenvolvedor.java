package br.com.devfinder.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Ronaldo Costa
 *
 */
@Entity
@Table(name = "DESENVOLVEDOR")
public class Desenvolvedor extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "NOME", nullable = false)
	private String nome;

	@Column(name = "CPF", length = 11, nullable = false)
	private String cpf;

	@Column(name = "DATA_NASCIMENTO", length = 11, nullable = false)
	private String dataNascimento;

	@Column(name = "TEMPO_EXPERIENCIA", nullable = false)
	private Short tempoExperiencia;

	@Column(name = "LINKEDIN", nullable = true)
	private String linkedIn;

	@Column(name = "GITHUB", nullable = false)
	private String gitHub;

	@Column(name = "CURRICULO", nullable = true)
	private String curriculo;

	@OneToMany(mappedBy = "desenvolvedor", cascade = CascadeType.ALL)
	private List<DesenvolvedorAreaAtuacao> areasAtuacao;

	@OneToMany(mappedBy = "desenvolvedor", cascade = CascadeType.ALL)
	private List<DesenvolvedorHabilidade> habilidade;

	@OneToMany(mappedBy = "desenvolvedor", cascade = CascadeType.ALL)
	private List<DesenvolvedorNotificacao> notificacoes;

	@OneToMany(mappedBy = "desenvolvedor", cascade = CascadeType.ALL)
	private List<Solucao> solucoes;

	public Desenvolvedor() {
		super();
	}

	public Desenvolvedor(String email, String foto, String senha, Endereco endereco, String site, String telefone,
			String apresentacao, String nome, String cpf, String dataNascimento, Short tempoExperiencia,
			String linkedIn, String gitHub, String curriculo) {
		super(email, foto, senha, endereco, site, telefone, apresentacao);
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.tempoExperiencia = tempoExperiencia;
		this.linkedIn = linkedIn;
		this.gitHub = gitHub;
		this.curriculo = curriculo;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Short getTempoExperiencia() {
		return tempoExperiencia;
	}

	public void setTempoExperiencia(Short tempoExperiencia) {
		this.tempoExperiencia = tempoExperiencia;
	}

	public String getLinkedIn() {
		return linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

	public String getGitHub() {
		return gitHub;
	}

	public void setGitHub(String gitHub) {
		this.gitHub = gitHub;
	}

	public String getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}

	public List<DesenvolvedorAreaAtuacao> getAreasAtuacao() {
		return areasAtuacao;
	}

	public void setAreasAtuacao(List<DesenvolvedorAreaAtuacao> areasAtuacao) {
		this.areasAtuacao = areasAtuacao;
	}

	public List<DesenvolvedorHabilidade> getHabilidade() {
		return habilidade;
	}

	public void setHabilidade(List<DesenvolvedorHabilidade> habilidade) {
		this.habilidade = habilidade;
	}

	public List<DesenvolvedorNotificacao> getNotificacoes() {
		return notificacoes;
	}

	public void setNotificacoes(List<DesenvolvedorNotificacao> notificacoes) {
		this.notificacoes = notificacoes;
	}

	public List<Solucao> getSolucoes() {
		return solucoes;
	}

	public void setSolucoes(List<Solucao> solucoes) {
		this.solucoes = solucoes;
	}
}
