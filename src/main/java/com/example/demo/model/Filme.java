package com.example.demo.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToMany;

@Table(name = "tb_filme")
@Entity
public class Filme extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    
    @Column(name = "nm_titulo",length = 50)
    private String titulo;
    
    @Column(name = "dt_filme",length = 20)
    private int ano;
    
    @ManyToMany
    private List<Ator> atores;
    
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
	
	public List<Ator> getAtores() {
		return atores;
	}

}
