package br.com.devfinder.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Ronaldo Costa
 *
 */

@Embeddable
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "ESTADO", length = 55, nullable = false)
	private String estado;
	
	@Column(name = "CIDADE", length = 55, nullable = false)
	private String cidade;
	
	@Column(name = "BAIRRO", length = 55, nullable = true)
	private String bairro;
	
	@Column(name = "RUA", length = 55, nullable = false)
	private String rua;
	
	@Column(name = "NUMERO", length = 55, nullable = false)
	private String numero;
	
	@Column(name = "CEP", length = 9, nullable = false)
	private String cep;

	public Endereco() {
	}

	public Endereco(String estado, String cidade, String bairro, String rua, String numero, String cep) {
		this.estado = estado;
		this.cidade = cidade;
		this.bairro = bairro;
		this.rua = rua;
		this.numero = numero;
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
}
