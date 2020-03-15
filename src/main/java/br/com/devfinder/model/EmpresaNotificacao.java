package br.com.devfinder.model;

/**
 * @author Ronaldo Costa
 *
 */
public class EmpresaNotificacao {

	private String emailEmpresa;
	private String data;
	private String horario;
	private String mensagem;

	public EmpresaNotificacao() {
	}

	public EmpresaNotificacao(String emailEmpresa, String data, String horario, String mensagem) {
		this.emailEmpresa = emailEmpresa;
		this.data = data;
		this.horario = horario;
		this.mensagem = mensagem;
	}

	public String getEmailEmpresa() {
		return emailEmpresa;
	}

	public String getData() {
		return data;
	}

	public String getHorario() {
		return horario;
	}

	public String getMensagem() {
		return mensagem;
	}
}
