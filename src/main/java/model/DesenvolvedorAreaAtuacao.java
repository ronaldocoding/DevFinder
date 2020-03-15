package model;

/**
 * @author Ronaldo Costa
 *
 */
public class DesenvolvedorAreaAtuacao {

	private String emailDesenvolvedor;
	private String areaAtuacao;

	public DesenvolvedorAreaAtuacao() {
	}

	public DesenvolvedorAreaAtuacao(String emailDesenvolvedor, String areaAtuacao) {
		this.emailDesenvolvedor = emailDesenvolvedor;
		this.areaAtuacao = areaAtuacao;
	}

	public String getEmailDesenvolvedor() {
		return emailDesenvolvedor;
	}

	public String getAreaAtuacao() {
		return areaAtuacao;
	}
}
