package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "tb_filme")
@Entity
public class Filme extends RefId {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "nm_titulo",length = 50)
    private String titulo;
    
    @Column(name = "dt_filme",length = 20)
    private int ano;
    
    public Filme () {
    	
    }
    
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}

}
