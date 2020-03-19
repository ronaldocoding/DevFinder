package br.com.devfinder.model;

import java.util.ArrayList;
import java.util.Calendar;

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
	private Calendar dataHoraFim;
	private ArrayList<Solucao> solucoes;
	private ArrayList<DesafioHabilidade> habilidades;

	public Desafio() {
	}

	public Desafio(String emailEmpresa, int id, String nome, String areaDesenvolvimento, String descricao,
			Calendar dataHoraFim) {
		this.emailEmpresa = emailEmpresa;
		this.id = id;
		this.nome = nome;
		this.areaDesenvolvimento = areaDesenvolvimento;
		this.descricao = descricao;
		this.dataHoraFim = dataHoraFim;
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

	public Calendar getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(Calendar dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
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
