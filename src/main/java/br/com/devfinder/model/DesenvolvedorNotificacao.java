package br.com.devfinder.model;

import java.util.Calendar;

/**
 * @author Ronaldo Costa
 *
 */
public class DesenvolvedorNotificacao {

	private String emailDesenvolvedor;
	private Calendar dataHora;
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
