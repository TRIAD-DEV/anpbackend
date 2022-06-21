package br.com.triadpesquisa.anp.model;

import br.com.triadpesquisa.anp.entity.Bandeira;
import br.com.triadpesquisa.anp.entity.Endereco;
import br.com.triadpesquisa.anp.entity.Estado;
import br.com.triadpesquisa.anp.entity.Posto;
import br.com.triadpesquisa.anp.entity.Situacao;

public class PostoVo {
	
	//CNPJ, RAZAOSOCIAL, NOMEFANTASIA, BANDEIRA,SITUACAO,ENDREREco,COMPLEMENTO,BAIRRO,CIDADE,UF,REGIAO,LAT,LONG
	
	private Long codigo;
	private String cnpj;
	private String razaoSocial;
	private String nomeFantasia;
	
	private String bandeira;
	private String situacao;
	private String endereco;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String regiao;
	private float latitude;
	private float longitude;

	public PostoVo(Posto posto) {
		this.codigo = posto.getId();
		this.cnpj = posto.getCnpj();
		this.razaoSocial = posto.getRazaoSocial();
		this.nomeFantasia = posto.getNomeFantasia();
		this.bandeira = posto.getBandeira().getNome();
		this.situacao = posto.getSituacao().getNome();
		this.endereco = posto.getEndereco().getEndereco();
		this.complemento = posto.getEndereco().getComplemento();
		this.bairro = posto.getEndereco().getBairro();
		this.cidade = posto.getEndereco().getCidade();
		this.uf = posto.getEndereco().getEstado().getSigla();
		this.regiao = posto.getEndereco().getEstado().getRegiao().getSigla();
		this.latitude = posto.getEndereco().getLatitude();
		this.longitude = posto.getEndereco().getLongitude();
		
	}

	public Long getCodigo() {
		return codigo;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public String getBandeira() {
		return bandeira;
	}

	public String getSituacao() {
		return situacao;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public String getUf() {
		return uf;
	}

	public String getRegiao() {
		return regiao;
	}

	public float getLatitude() {
		return latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	
	

}
