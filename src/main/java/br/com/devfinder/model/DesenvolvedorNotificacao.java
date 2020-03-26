package br.com.devfinder.model;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Ronaldo Costa
 *
 */
@Entity
public class DesenvolvedorNotificacao {

	@Id
	private String emailDesenvolvedor;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataHora;
	@Id
	private int id;
	@Id
	private String titulo;
	private String mensagem;
	@ManyToOne
	private Desenvolvedor desenvolvedor;

	public DesenvolvedorNotificacao() {
	}

	public DesenvolvedorNotificacao(String emailDesenvolvedor, Calendar dataHora, String mensagem) {
		this.emailDesenvolvedor = emailDesenvolvedor;
		this.dataHora = dataHora;
		this.mensagem = mensagem;
	}

	public String getEmailDesenvolvedor() {
		return emailDesenvolvedor;
	}

	public Calendar getDataHora() {
		return dataHora;
	}

	public int getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
	
	public String getMensagem() {
		return mensagem;
	}

	public Desenvolvedor getDesenvovledor() {
		return desenvolvedor;
	}
}
