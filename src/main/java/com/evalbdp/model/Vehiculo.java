package com.evalbdp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Vehiculo")
public class Vehiculo {
   
    @Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name ="placa", length=20)
	private String placa;
	@Column(name ="marca", length=100)
	private String marca;
	@Column(name ="modelo", length=100)
	private String modelo;

//    @ManyToMany(mappedBy = "Vehiculo")
//    private List<Bien> bienes;
	
	public Vehiculo() {
	}
	public Vehiculo(String placa,String marca, String modelo) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
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
	
}
