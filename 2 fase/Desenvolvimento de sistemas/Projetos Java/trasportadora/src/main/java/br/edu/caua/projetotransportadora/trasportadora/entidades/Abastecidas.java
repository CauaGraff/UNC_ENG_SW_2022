package br.edu.caua.projetotransportadora.trasportadora.entidades;

import java.io.Serializable;


public class Abastecidas implements Serializable {

	private static final long serialVersionUID = 1L;

	
	
	// ATRIBUTOS
	
	private Float valor;
	
	private String tipoProduto;
	
	private Float quantidade;
	
	private Integer veiculoId;
	
	private Integer contaId;

	private Integer id;


	
	// METODOS GET E SET
	
	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public Float getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Float quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(Integer veiculoId) {
		this.veiculoId = veiculoId;
	}

	public Integer getContaId() {
		return contaId;
	}

	public void setContaId(Integer contaId) {
		this.contaId = contaId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
