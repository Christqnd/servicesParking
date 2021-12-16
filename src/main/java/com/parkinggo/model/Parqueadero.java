package com.parkinggo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Parqueadero")
public class Parqueadero {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "codigo", length = 100)
	private String codigo;

	@Column(name = "numero", length = 100)
	private int numero;
	
	@Column(name = "nombre", length = 200)
	private String nombre;
	
	@Column(name = "descripcion", length = 1000)
	private String descripcion;

	@Column(name = "estado", length = 100)
	private String estado;
	
	@Column(name = "fechacreacion")
	private LocalDateTime fechaCreacion;

	@Column(name = "capacidad", length = 100)
	private int capacidad;
	
	@Column(name = "ocupados", length = 100)
	private int ocupados;
	
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(foreignKey = @ForeignKey(name = "empresa_id"),name = "empresa_id", nullable = true)
	@JsonIgnore private Empresa empresa;
	

    @OneToMany(mappedBy = "parqueadero",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Puerta> puertas;

    
	public Parqueadero(String codigo, int numero, String nombre ,String descripcion, int capacidad, int ocupados) {
		super();
		this.codigo = codigo;
		this.numero = numero;
		this.nombre= nombre;
		this.descripcion = descripcion;
		this.capacidad = capacidad;
		this.ocupados = ocupados;
		this.estado="A";
		this.fechaCreacion= LocalDateTime.now();
		this.puertas = new LinkedList<Puerta>();
	}

	
	public Parqueadero() {
		super();
	}


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

	
	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public List<Puerta> getPuertas() {
		return puertas;
	}

	public void setPuertas(List<Puerta> puertas) {
		this.puertas = puertas;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	

}
