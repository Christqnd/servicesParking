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
@Table(name = "Categoria")
public class Categoria {

	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name ="nombre", length=100)
	private String nombre;

    @ManyToMany(mappedBy = "categorias")
    private List<Bien> bienes;
	
	public Categoria() {
	}
	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Bien> getBienes() {
		return bienes;
	}
	public void setBienes(List<Bien> bienes) {
		this.bienes = bienes;
	}

}
