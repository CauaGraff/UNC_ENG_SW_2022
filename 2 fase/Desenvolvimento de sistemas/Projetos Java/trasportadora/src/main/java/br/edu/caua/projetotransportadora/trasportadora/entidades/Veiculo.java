package br.edu.caua.projetotransportadora.trasportadora.entidades;

import java.io.Serializable;

public class Veiculo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	//ATRIBUTOS
	private Integer id;
	
	private Integer motoristaId;
	
	private Integer reboqueId;
	
	private Integer contaId;
	
	private String placa;
	
	private Float kilometragem;
	
	private String cor;
	
	private Integer ano;
	
	private String marca;
	
	private String numChassi;
	
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

	public Integer getReboqueId() {
		return reboqueId;
	}

	public void setReboqueId(Integer reboqueId) {
		this.reboqueId = reboqueId;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Float getKilometragem() {
		return kilometragem;
	}

	public void setKilometragem(Float kilometragem) {
		this.kilometragem = kilometragem;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getNumChassi() {
		return numChassi;
	}

	public void setNumChassi(String numChassi) {
		this.numChassi = numChassi;
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
