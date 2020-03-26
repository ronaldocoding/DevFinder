package br.com.devfinder.model.ids;

import javax.persistence.Embeddable;

/**
 * @author Ronaldo Costa
 *
 */
@Embeddable
public class DesenvolvedorAreaAtuacaoId {

	private String emailDesenvolvedor;
	private String areaAtuacao;
	public String getEmailDesenvolvedor() {
		return emailDesenvolvedor;
	}
	public void setEmailDesenvolvedor(String emailDesenvolvedor) {
		this.emailDesenvolvedor = emailDesenvolvedor;
	}
	public String getAreaAtuacao() {
		return areaAtuacao;
	}
	public void setAreaAtuacao(String areaAtuacao) {
		this.areaAtuacao = areaAtuacao;
	}
}
