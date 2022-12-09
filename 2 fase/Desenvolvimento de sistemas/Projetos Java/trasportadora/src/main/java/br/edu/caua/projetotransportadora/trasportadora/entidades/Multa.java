package br.edu.caua.projetotransportadora.trasportadora.entidades;

import java.io.Serializable;
import java.util.Date;

public class Multa implements Serializable {
	private static final long serialVersionUID = 1L;

	
	// ATRIBUTOS
	
	private Integer id;
	
	private Integer motoristaId;
	
	private Integer veiculoId;
	
	private Integer contaId;
	
	private String tipo;
	
	private String local;
	
	private Date data;
	
	private Float valor;
	
	// METODOS GET E SET


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMotoristaId() {
		return motoristaId;
	}

	public void setMotoristaId(Integer motoristaId) {
		this.motoristaId = motoristaId;
	}

	public Integer getVeiculoId() {
		return veiculoId;
	}

	public void setVeiculoId(Integer veiculoId) {
		this.veiculoId = veiculoId;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getContaId() {
		return contaId;
	}

	public void setContaId(Integer contaId) {
		this.contaId = contaId;
	}

	
	

	
	
}
