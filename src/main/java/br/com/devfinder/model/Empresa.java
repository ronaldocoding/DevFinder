package br.com.devfinder.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Ronaldo Costa
 *
 */
@Entity
@Table(name = "EMPRESA")
public class Empresa extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "NOME_FANTASIA", length = 55, nullable = false)
	private String nomeFantasia;

	@Column(name = "RAZAO_SOCIAL", length = 55, nullable = false)
	private String razaoSocial;

	@Column(name = "CNPJ", length = 18, nullable = false)
	private String cnpj;
	
	@Column(name = "ANO_FUNDACAO", nullable = false)
	private int anoFundacao;

	@Column(name = "RAMO_MERCADO", length = 55, nullable = false)
	private String ramoMercado;

	@Column(name = "TOTAL_DESENVOLVEDORES", nullable = false)
	private int totalDesenvolvedores;

	/*
	@Column(name = "VAGAS_REMOTAS", nullable = false)
	private boolean vagasRemotas;

	@Column(name = "VAGAS_FISICAS", nullable = false)
	private boolean vagasFisicas;
	*/
	@Column(name = "TIPO_VAGA", length = 55, nullable = false)
	private String tipoVaga;

	public String getTipoVaga() {
		return tipoVaga;
	}

	public void setTipoVaga(String tipoVaga) {
		this.tipoVaga = tipoVaga;
	}

	public void setAnoFundacao(int anoFundacao) {
		this.anoFundacao = anoFundacao;
	}

	public Empresa() {
		super();
	}

	public Empresa(String email, String foto, String senha, Endereco endereco, String site, String telefone,
			String apresentacao, String nomeFantasia, String razaoSocial, String cnpj, Integer anoFundacao,
			String ramoMercado, int totalDesenvolvedores,String tipoVagas) {
		super(email, foto, senha, endereco, site, telefone, apresentacao);
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.anoFundacao = anoFundacao;
		this.ramoMercado = ramoMercado;
		this.totalDesenvolvedores = totalDesenvolvedores;
		
		this.tipoVaga = tipoVaga;
		
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

	public void setAnoFundacao(Integer anoFundacao) {
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

}
