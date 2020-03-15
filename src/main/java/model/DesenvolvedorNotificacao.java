package model;

/**
 * @author Ronaldo Costa
 *
 */
public class DesenvolvedorNotificacao {

	private String emailDesenvolvedor;
	private String data;
	private String horario;
	private String mensagem;

	public DesenvolvedorNotificacao() {
	}

	public DesenvolvedorNotificacao(String emailDesenvolvedor, String data, String horario, String mensagem) {
		this.emailDesenvolvedor = emailDesenvolvedor;
		this.data = data;
		this.horario = horario;
		this.mensagem = mensagem;
	}

	public String getEmailDesenvolvedor() {
		return emailDesenvolvedor;
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
