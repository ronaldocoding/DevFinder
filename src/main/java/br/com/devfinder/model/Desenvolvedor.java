package br.com.devfinder.model;

import java.util.Calendar;

/**
 * @author Ronaldo Costa
 *
 */
public class Desenvolvedor extends Usuario {

	private String nome;
	private String cpf;
	private Calendar dataNascimento;
	private String tempoExperiencia;
	private String linkedIn;
	private String gitHub;
	private String curriculo;

	public Desenvolvedor() {
		super();
	}

	public Desenvolvedor(String email, String foto, String senha, Endereco endereco, String site, String telefone,
			String apresentacao, String nome, String cpf, Calendar dataNascimento, String tempoExperiencia,
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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTempoExperiencia() {
		return tempoExperiencia;
	}

	public void setTempoExperiencia(String tempoExperiencia) {
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
