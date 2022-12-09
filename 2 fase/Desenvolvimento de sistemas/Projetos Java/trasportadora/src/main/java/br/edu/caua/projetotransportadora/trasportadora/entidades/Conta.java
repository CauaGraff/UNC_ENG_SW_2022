package br.edu.caua.projetotransportadora.trasportadora.entidades;

import java.io.Serializable;

public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	
	
	// ATRIBUTOS
	private Integer id;
	
	private String tipo;
	
	private Float valor;
	
	private Integer nf;
	
	private Integer cte;
	
	private String descricao;
	
	// METODOS GET E SET


	public Integer getNf() {
		return nf;
	}

	public void setNf(Integer nf) {
		this.nf = nf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Integer getCte() {
		return cte;
	}

	public void setCte(Integer cte) {
		this.cte = cte;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	


	
	
	
	
}
