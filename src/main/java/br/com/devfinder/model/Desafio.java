package br.com.devfinder.model;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Ronaldo Costa
 *
 */
@Entity
public class Desafio {

	@Id
	private String emailEmpresa;
	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private Empresa empresa;
	private String nome;
	private String areaDesenvolvimento;
	private String descricao;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataHoraFim;

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

	public Empresa getEmpresa() {
		return empresa;
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
}
