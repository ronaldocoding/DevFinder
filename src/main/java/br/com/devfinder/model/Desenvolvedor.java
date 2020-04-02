package br.com.devfinder.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Ronaldo Costa
 *
 */
@Entity
@Table(name = "DESENVOLVEDOR")
public class Desenvolvedor extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "NOME", length = 55, nullable = false)
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
}
