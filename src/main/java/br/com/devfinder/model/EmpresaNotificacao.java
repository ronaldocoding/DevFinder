package br.com.devfinder.model;

import java.util.Calendar;

/**
 * @author Ronaldo Costa
 *
 */
public class EmpresaNotificacao {

	private String emailEmpresa;
	private Calendar dataHora;
	private String mensagem;

	public EmpresaNotificacao() {
	}

	public EmpresaNotificacao(String emailEmpresa, Calendar dataHora, String mensagem) {
		this.emailEmpresa = emailEmpresa;
		this.dataHora = dataHora;
		this.mensagem = mensagem;
	}

	public String getEmailEmpresa() {
		return emailEmpresa;
	}

	public Calendar getDataHora() {
		return dataHora;
	}

	public String getMensagem() {
		return mensagem;
	}
}
