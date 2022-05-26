package br.com.triadpesquisa.anp.model;

import br.com.triadpesquisa.anp.entity.Estado;

public class EstadoVo {
	private Long codigo;
	private String sigla;
	private String nome;
	
	public EstadoVo(Estado estado) {
		this.codigo = estado.getId();
		this.sigla = estado.getSigla();
		this.nome = estado.getNome();
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public String getSigla() {
		return sigla;
	}
	public String getNome() {
		return nome;
	}
}
