package com.bd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "posto")
public class Posto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pos_id")
	private long id;
	@Column(name = "pos_nome")
	private String nome;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
