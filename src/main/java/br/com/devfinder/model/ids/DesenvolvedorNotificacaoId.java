package br.com.devfinder.model.ids;

import java.util.Calendar;

/**
 * @author Ronaldo Costa
 *
 */
public class DesenvolvedorNotificacaoId {

	private String emailDesenvolvedor;
	private Calendar dataHora;
	private int id;

	public String getEmailDesenvolvedor() {
		return emailDesenvolvedor;
	}

	public void setEmailDesenvolvedor(String emailDesenvolvedor) {
		this.emailDesenvolvedor = emailDesenvolvedor;
	}

	public Calendar getDataHora() {
		return dataHora;
	}

	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
