package com.parkinggo.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@Column(name = "id_usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUsuario;

	@Column(name = "nombre", length = 100)
	private String nombre;

	@Column(name = "apellido", length = 100)
	private String apellido;

	@Column(name = "cedula", length = 100)
	private String cedula;

	@Column(name = "telefono", length = 100)
	private String telefono;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Vehiculo> vehiculos;
//    private Tarjeta tarjeta;
//    private Tarifa tarifa;

	public Usuario(String nombre, String apellido, String cedula, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.telefono = telefono;
		this.vehiculos = new LinkedList<Vehiculo>();
	}

	public Usuario() {
		super();
		this.nombre = "";
		this.apellido = "";
		this.cedula = "";
		this.telefono = "";
		this.vehiculos = new LinkedList<Vehiculo>();
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	public void addVehiculo(Vehiculo vehiculo) {
		if (this.vehiculos == null) {
			this.vehiculos = new LinkedList<Vehiculo>();
		}
		this.vehiculos.add(vehiculo);
	}

//    private List<Factura> facturas;

}
