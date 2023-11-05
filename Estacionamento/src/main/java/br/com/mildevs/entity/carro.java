package br.com.mildevs.entity;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class carro {
	
	@Id
	private String placa;
	
	@Column(nullable = false)
	private String cor;
	
	@Column(nullable = false)
	private String marca;
	
	@Column(nullable = false)
	private String modelo;

	@Column(name = "vel_max", nullable = false)
	private double velmax;
	
	

	public carro(String placa, String cor, String marca, String modelo, double vel_max) {
		this.placa = placa;
		this.cor = cor;
		this.marca = marca;
		this.modelo = modelo;
		this.velmax = vel_max;
	}
	
	public carro() {
	}


	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public double getVel_max() {
		return velmax;
	}

	public void setVel_max(double vel_max) {
		this.velmax = vel_max;
	}

	@Override
	public String toString() {
		return "carro: placa do carro: " + placa + ",\n cor do carro: " + cor + ",\n marca do carro: " + marca
				+ ",\n modelo do carro: " + modelo + " \n velocide maxima: " + velmax;
	}
}
