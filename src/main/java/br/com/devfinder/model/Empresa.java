package br.com.devfinder.model;

import javax.persistence.Entity;

/**
 * @author Ronaldo Costa
 *
 */
@Entity
public class Empresa extends Usuario {

	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	private int anoFundacao;
	private String ramoMercado;
	private int totalDesenvolvedores;
	private boolean vagasRemotas;
	private boolean vagasFisicas;

	public Empresa() {
		super();
	}

	public Empresa(String email, String foto, String senha, Endereco endereco, String site, String telefone,
			String apresentacao, String nomeFantasia, String razaoSocial, String cnpj, int anoFundacao,
			String ramoMercado, int totalDesenvolvedores, boolean vagasRemotas, boolean vagasFisicas) {
		super(email, foto, senha, endereco, site, telefone, apresentacao);
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.anoFundacao = anoFundacao;
		this.ramoMercado = ramoMercado;
		this.totalDesenvolvedores = totalDesenvolvedores;
		this.vagasRemotas = vagasRemotas;
		this.vagasFisicas = vagasFisicas;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public int getAnoFundacao() {
		return anoFundacao;
	}

	public void setAnoFundacao(int anoFundacao) {
		this.anoFundacao = anoFundacao;
	}

	public String getRamoMercado() {
		return ramoMercado;
	}

	public void setRamoMercado(String ramoMercado) {
		this.ramoMercado = ramoMercado;
	}

	public int getTotalDesenvolvedores() {
		return totalDesenvolvedores;
	}

	public void setTotalDesenvolvedores(int totalDesenvolvedores) {
		this.totalDesenvolvedores = totalDesenvolvedores;
	}

	public boolean isVagasRemotas() {
		return vagasRemotas;
	}

	public void setVagasRemotas(boolean vagasRemotas) {
		this.vagasRemotas = vagasRemotas;
	}

	public boolean isVagasFisicas() {
		return vagasFisicas;
	}

	public void setVagasFisicas(boolean vagasFisicas) {
		this.vagasFisicas = vagasFisicas;
	}
}
