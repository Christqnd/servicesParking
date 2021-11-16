package com.parkinggo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Parqueadero")
public class Parqueadero {

    @Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "codigo", length = 100)
	private String codigo;
    
	@Column(name = "numero", length = 100)
	private int numero;    
	@Column(name = "capacidad", length = 100)
    private int capacidad;
	@Column(name = "ocupados", length = 100)
    private int ocupados;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "Parqueadero")
//    private List<Puerta> puertas = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getOcupados() {
		return ocupados;
	}

	public void setOcupados(int ocupados) {
		this.ocupados = ocupados;
	}

//	public List<Puerta> getPuertas() {
//		return puertas;
//	}
//
//	public void setPuertas(List<Puerta> puertas) {
//		this.puertas = puertas;
//	}

    
}
