package br.com.triadpesquisa.anp.model;

import br.com.triadpesquisa.anp.entity.Situacao;

public class SituacaoVo {
	private Long codigo;
	private String nome;
	
	public SituacaoVo(Situacao situacao) {
		this.codigo = situacao.getId();
		this.nome = situacao.getNome();
	}
	
	public Long getCodigo() {
		return codigo;
	}
	public String getNome() {
		return nome;
	}
}
