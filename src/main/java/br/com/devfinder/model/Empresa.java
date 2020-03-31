package br.com.devfinder.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Ronaldo Costa
 *
 */
@Entity
@Table(name = "EMPRESA")
public class Empresa extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "NOME_FANTASIA", nullable = false)
	private String nomeFantasia;

	@Column(name = "RAZAO_SOCIAL", nullable = false)
	private String razaoSocial;

	@Column(name = "CNPJ", nullable = false)
	private String cnpj;

	@Column(name = "ANO_FUNDACAO", nullable = false)
	private int anoFundacao;

	@Column(name = "RAMO_MERCADO", nullable = false)
	private String ramoMercado;

	@Column(name = "TOTAL_DESENVOLVEDORES", nullable = false)
	private int totalDesenvolvedores;

	@Column(name = "VAGAS_REMOTAS", nullable = false)
	private boolean vagasRemotas;

	@Column(name = "VAGAS_FISICAS", nullable = false)
	private boolean vagasFisicas;

	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private List<Desafio> desafios;

	@OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
	private List<EmpresaNotificacao> notificacoes;

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

	public List<Desafio> getDesafios() {
		return desafios;
	}

	public void setDesafios(List<Desafio> desafios) {
		this.desafios = desafios;
	}

	public List<EmpresaNotificacao> getNotificacoes() {
		return notificacoes;
	}

	public void setNotificacoes(List<EmpresaNotificacao> notificacoes) {
		this.notificacoes = notificacoes;
	}
}
