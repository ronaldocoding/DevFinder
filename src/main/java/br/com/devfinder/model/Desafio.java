package br.com.devfinder.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.devfinder.model.ids.DesafioId;

/**
 * @author Ronaldo Costa
 *
 */
@Entity
@IdClass(DesafioId.class)
@Table(name = "DESAFIO")
public class Desafio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EMAIL_EMPRESA", length = 55)
	private String emailEmpresa;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "EMAIL_EMPRESA", referencedColumnName = "EMAIL", nullable = false, insertable = false, updatable = false)
	private Empresa empresa;

	@Column(name = "NOME", length = 55, nullable = false)
	private String nome;

	@Column(name = "AREA_DESENVOLVIMENTO", length = 55, nullable = false)
	private String areaDesenvolvimento;

	@Column(name = "DESCRICAO", nullable = false)
	private String descricao;

	@Column(name = "DATA_FIM", length = 11, nullable = false)
	private String dataFim;

	@Column(name = "HORARIO_FIM", length = 5, nullable = false)
	private String horarioFim;

	public Desafio() {
	}

	public Desafio(String emailEmpresa, int id, String nome, String areaDesenvolvimento, String descricao,
			String dataFim, String horarioFim) {
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

	public void setEmailEmpresa(String emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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

	public void setAreaDesenvolvimento(String areaDesenvolvimento) {
		this.areaDesenvolvimento = areaDesenvolvimento;
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
}
