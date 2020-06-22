package br.com.devfinder.model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.devfinder.model.ids.DesenvolvedorDesafioId;

/**
 * @author Ronaldo Costa
 *
 */
@Entity
@Table(name = "DESENVOLVEDOR_DESAFIO")
public class DesenvolvedorDesafio implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DesenvolvedorDesafioId id = new DesenvolvedorDesafioId();

	@Column(name = "DATA_INSCRICAO")
	private String dataInscricao;

	@Column(name = "HORA_INSCRICAO")
	private String horarioInscricao;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EMAIL_DESENVOLVEDOR", referencedColumnName = "EMAIL", nullable = false, insertable = false, updatable = false)
	private Desenvolvedor desenvolvedor;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumns(value = {
			@JoinColumn(name = "EMAIL_EMPRESA_DESAFIO", referencedColumnName = "EMAIL_EMPRESA", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "ID_DESAFIO", referencedColumnName = "ID", nullable = false, insertable = false, updatable = false) })
	private Desafio desafio;

	public DesenvolvedorDesafio() {
	}

	public DesenvolvedorDesafio(String emailDesenvolvedor, String emailEmpresa, int idDesafio) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat timeFormat = new SimpleDateFormat("HH:mm");
	    Date date = new Date();
		id.setEmailDesenvolvedor(emailDesenvolvedor);
		id.setEmailEmpresa(emailEmpresa);
		id.setIdDesafio(idDesafio);
		this.dataInscricao = dateFormat.format(date);
		this.horarioInscricao = timeFormat.format(date);
	}

	public DesenvolvedorDesafioId getId() {
		return id;
	}

	public void setId(DesenvolvedorDesafioId id) {
		this.id = id;
	}

	public String getDataInscricao() {
		return dataInscricao;
	}

	public void setDataInscricao(String dataInscricao) {
		this.dataInscricao = dataInscricao;
	}

	public String getHorarioInscricao() {
		return horarioInscricao;
	}

	public void setHorarioInscricao(String horarioInscricao) {
		this.horarioInscricao = horarioInscricao;
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
