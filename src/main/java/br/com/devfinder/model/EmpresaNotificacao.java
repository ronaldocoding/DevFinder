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
public class EmpresaNotificacao {
	
	@Id
	private String emailEmpresa;
	@Id
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataHora;
	@Id
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
