package model;

/**
 * @author Ronaldo Costa
 *
 */
public class DesafioHabilidade {

	private String emailEmpresa;
	private int idDesafio;
	private String habilidade;

	public DesafioHabilidade() {
	}

	public DesafioHabilidade(String emailEmpresa, int idDesafio, String habilidade) {
		this.emailEmpresa = emailEmpresa;
		this.idDesafio = idDesafio;
		this.habilidade = habilidade;
	}

	public String getEmailEmpresa() {
		return emailEmpresa;
	}

	public int getIdDesafio() {
		return idDesafio;
	}

	public String getHabilidade() {
		return habilidade;
	}

}
