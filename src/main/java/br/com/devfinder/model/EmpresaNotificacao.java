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

import br.com.devfinder.model.ids.EmpresaNotificacaoId;

/**
 * @author Ronaldo Costa
 *
 */
@Entity
@IdClass(EmpresaNotificacaoId.class)
@Table(name = "EMPRESA_NOTIFICACAO")
public class EmpresaNotificacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "EMAIL_EMPRESA", length = 55)
	private String emailEmpresa;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@Id
	@Column(name = "TITULO", length = 125)
	private String titulo;

	@Column(name = "DATA_ENVIO", length = 11, nullable = false)
	private String dataEnvio;

	@Column(name = "HORARIO_ENVIO", length = 5, nullable = false)
	private String horarioEnvio;

	@Column(name = "MENSAGEM", nullable = false)
	private String mensagem;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "EMAIL_EMPRESA", referencedColumnName = "EMAIL", nullable = false, insertable = false, updatable = false)
	private Empresa empresa;

	public EmpresaNotificacao() {
	}

	public EmpresaNotificacao(String emailEmpresa, int id, String titulo, String dataEnvio, String horarioEnvio,
			String mensagem, Empresa empresa) {
		this.emailEmpresa = emailEmpresa;
		this.id = id;
		this.titulo = titulo;
		this.dataEnvio = dataEnvio;
		this.horarioEnvio = horarioEnvio;
		this.mensagem = mensagem;
		this.empresa = empresa;
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
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

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
