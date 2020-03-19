package br.com.devfinder.model;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	@Id
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataHora;
	@Id
	private String mensagem;

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

	public String getMensagem() {
		return mensagem;
	}
}
