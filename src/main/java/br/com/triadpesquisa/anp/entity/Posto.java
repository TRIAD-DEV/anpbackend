package br.com.triadpesquisa.anp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.triadpesquisa.anp.Bean.PostoBean;

@Entity
@Table(name = "tb_posto")
public class Posto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "cnpj")
	private String cnpj;
	
	@Column(name = "razaosocial")
	private String razaoSocial;
	
	@Column(name = "nomefantasia")
	private String nomeFantasia;
	
	@Column(name = "dataatualizacao")
	private Date dataAtualizacao;
	
	@OneToOne
	@JoinColumn(name = "enderecoid", nullable = false)
	private Endereco endereco;
	
	@ManyToOne
	@JoinColumn(name = "situacaoid", nullable = false)
	private Situacao situacao;

	@ManyToOne
	@JoinColumn(name = "bandeiraid", nullable = false)
	private Bandeira bandeira;
	
	public Posto(PostoBean posto) {
		this.cnpj = posto.getCnpj();
		this.razaoSocial = posto.getRazaoSocial();
		this.nomeFantasia = posto.getNomeFantasia();
		this.situacao = new Situacao();
		this.situacao.setId(posto.getSituacaoId());
		this.bandeira = new Bandeira();
		this.bandeira.setId(posto.getBandeiraId());
		
	}
	
	public Posto() {
		super();
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}

	public Bandeira getBandeira() {
		return bandeira;
	}

	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}

}
