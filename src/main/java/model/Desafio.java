package model;

import java.util.ArrayList;

/**
 * @author Ronaldo Costa
 *
 */
public class Desafio {

	private String emailEmpresa;
	private int id;
	private String nome;
	private String areaDesenvolvimento;
	private String descricao;
	private String dataFim;
	private String horarioFim;
	private ArrayList<Solucao> solucoes;
	private ArrayList<DesafioHabilidade> habilidades;

	public Desafio() {
	}

	public Desafio(String emailEmpresa, int id, String nome, String areaDesenvolvimento, String descricao,
			String dataFim, String horarioFim) {
		super();
		this.emailEmpresa = emailEmpresa;
		this.id = id;
		this.nome = nome;
		this.areaDesenvolvimento = areaDesenvolvimento;
		this.descricao = descricao;
		this.dataFim = dataFim;
		this.horarioFim = horarioFim;
	}

	public String getEmailEmpresa() {
		return emailEmpresa;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAreaDesenvolvimento() {
		return areaDesenvolvimento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public String getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(String horarioFim) {
		this.horarioFim = horarioFim;
	}

	public ArrayList<Solucao> getSolucoes() {
		return solucoes;
	}

	public ArrayList<DesafioHabilidade> getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(ArrayList<DesafioHabilidade> habilidades) {
		this.habilidades = habilidades;
	}
}
