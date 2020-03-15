package model;

/**
 * @author Ronaldo Costa
 *
 */
public class DesenvolvedorHabilidade {

	private String emailDesenvolvedor;
	private String habilidade;

	public DesenvolvedorHabilidade() {
	}

	public DesenvolvedorHabilidade(String emailDesenvolvedor, String habilidade) {
		this.emailDesenvolvedor = emailDesenvolvedor;
		this.habilidade = habilidade;
	}

	public String getEmailDesenvolvedor() {
		return emailDesenvolvedor;
	}

	public String getHabilidade() {
		return habilidade;
	}
}
