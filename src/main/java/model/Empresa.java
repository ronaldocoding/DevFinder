package model;

import java.util.ArrayList;

/**
 * @author Ronaldo Costa
 *
 */
public class Empresa extends Usuario{

	private String nomeFantasia;
	private String razaoSocial;
	private String cnpj;
	private int anoFundacao;
	private String ramoMercado;
	private int totalDesenvolvedores;
	private boolean vagasRemotas;
	private boolean vagasFisicas;
	private ArrayList<Desafio> desafios;
	private ArrayList<EmpresaNotificacao> notificacoes;
	
	public Empresa() {
		super();
	}

	public Empresa(String email, String foto, String senha, Endereco endereco, String site, String telefone,
			String apresentacao, String nomeFantasia, String razaoSocial, String cnpj, int anoFundacao,
			String ramoMercado, int totalDesenvolvedores, boolean vagasRemotas, boolean vagasFisicas,
			ArrayList<Desafio> desafios, ArrayList<EmpresaNotificacao> notificacoes) {
		super(email, foto, senha, endereco, site, telefone, apresentacao);
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.anoFundacao = anoFundacao;
		this.ramoMercado = ramoMercado;
		this.totalDesenvolvedores = totalDesenvolvedores;
		this.vagasRemotas = vagasRemotas;
		this.vagasFisicas = vagasFisicas;
		this.desafios = desafios;
		this.notificacoes = notificacoes;
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

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public ArrayList<Desafio> getDesafios() {
		return desafios;
	}

	public void setDesafios(ArrayList<Desafio> desafios) {
		this.desafios = desafios;
	}

	public ArrayList<EmpresaNotificacao> getNotificacoes() {
		return notificacoes;
	}

	public void setNotificacoes(ArrayList<EmpresaNotificacao> notificacoes) {
		this.notificacoes = notificacoes;
	}
}
