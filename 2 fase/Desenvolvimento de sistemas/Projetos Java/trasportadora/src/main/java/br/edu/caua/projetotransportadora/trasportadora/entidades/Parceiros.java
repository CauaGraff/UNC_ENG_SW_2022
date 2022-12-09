package br.edu.caua.projetotransportadora.trasportadora.entidades;

import java.io.Serializable;

public class Parceiros implements Serializable{
	
	private static final long serialVersionUID = 1L;


	// ATIBUTOS
	
	private Integer id;
	
	private String razaoSocial;
	
	private String servicoPrestado;
	
	private String cnpj;
	
	private String produto;

	// METODOS GET E SET
	
	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getServicoPrestado() {
		return servicoPrestado;
	}

	public void setServicoPrestado(String servicoPrestado) {
		this.servicoPrestado = servicoPrestado;
	}


	
	
}
