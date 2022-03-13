package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "tb_ator")
@Entity
public class Ator extends Filme{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "nm_ator", length = 50)
	private String nome;
	
	@Column(name = "dt_nascimento",length = 50)
	private Date nascimento;
	
	public Ator () {
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

}
