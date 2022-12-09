package br.edu.caua.projetotransportadora.trasportadora.entidades;

import java.io.Serializable;

public class Reboque implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	// ATRIBUTOS
	private Integer id;
	
	private String placa;
	
	private String renavam;
	
	private String ano;
	
	private String capacidade;
	
	// METODOS GET E SET

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	
}
