package br.com.devfinder.model;

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

import br.com.devfinder.model.ids.DesenvolvedorNotificacaoId;

/**
 * @author Ronaldo Costa
 *
 */
@Entity
@IdClass(DesenvolvedorNotificacaoId.class)
@Table(name = "DESENVOLVEDOR_NOTIFICACAO")
public class DesenvolvedorNotificacao {

	@Id
	@Column(name = "EMAIL_DESENVOLVEDOR")
	private String emailDesenvolvedor;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@Id
	@Column(name = "TITULO")
	private String titulo;

	@Column(name = "DATA_ENVIO", length = 11, nullable = false)
	private String dataEnvio;

	@Column(name = "HORARIO_ENVIO", length = 5, nullable = false)
	private String horarioEnvio;

	@Column(name = "MENSAGEM", nullable = false)
	private String mensagem;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "EMAIL_DESENVOLVEDOR", referencedColumnName = "EMAIL", nullable = false, insertable = false, updatable = false)
	private Desenvolvedor desenvolvedor;

	public DesenvolvedorNotificacao() {
	}

	public DesenvolvedorNotificacao(String emailDesenvolvedor, int id, String titulo, String dataEnvio,
			String horarioEnvio, String mensagem) {
		super();
		this.emailDesenvolvedor = emailDesenvolvedor;
		this.id = id;
		this.titulo = titulo;
		this.dataEnvio = dataEnvio;
		this.horarioEnvio = horarioEnvio;
		this.mensagem = mensagem;
	}

	public String getEmailDesenvolvedor() {
		return emailDesenvolvedor;
	}

	public void setEmailDesenvolvedor(String emailDesenvolvedor) {
		this.emailDesenvolvedor = emailDesenvolvedor;
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

	public Desenvolvedor getDesenvolvedor() {
		return desenvolvedor;
	}

	public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
		this.desenvolvedor = desenvolvedor;
	}
}
