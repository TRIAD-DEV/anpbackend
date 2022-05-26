package br.com.triadpesquisa.anp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_situacao")
public class Situacao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "permiteentrega")
	private boolean entrega;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public boolean isEntrega() {
		return entrega;
	}
}
