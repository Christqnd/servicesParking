package com.parkinggo.model;

import java.io.Serializable;
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
public class Usuario implements Serializable{

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "primer_nombre", length = 100)
	private String primerNombre;
	
	@Column(name = "segundo_nombre", length = 100)
	private String segundoNombre;
	
	@Column(name = "primer_apellido", length = 100)
	private String primerApellido;
	
	@Column(name = "segundo_apellido", length = 100)
	private String segundoApellido;

	@Column(name = "cedula", length = 100)
	private String cedula;

	@Column(name = "telefono", length = 100)
	private String telefono;

	@Column(name = "estado", length = 1)
	private String estado;

	@OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Vehiculo> vehiculos;
//    private Tarjeta tarjeta;
//    private Tarifa tarifa;

	public Usuario(String primerNombre,String segundoNombre, String primerApellido,String segundoApellido, String cedula, String telefono) {
		super();
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.cedula = cedula;
		this.telefono = telefono;
		this.estado="A";
		this.vehiculos = new LinkedList<Vehiculo>();
	}

	public Usuario() {
		super();
		this.primerNombre = "";
		this.segundoNombre="";
		this.segundoApellido="";
		this.primerApellido = "";
		this.cedula = "";
		this.telefono = "";
		this.estado="A";
		this.vehiculos = new LinkedList<Vehiculo>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
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
		for(Vehiculo v : vehiculos) {
            v.setUsuario(this);
        }
		this.vehiculos = vehiculos;
	}

	public void addVehiculo(Vehiculo vehiculo) {
		if (this.vehiculos == null) {
			this.vehiculos = new LinkedList<Vehiculo>();
		}
		vehiculo.setUsuario(this);
		this.vehiculos.add(vehiculo);
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}





	
	
//    private List<Factura> facturas;

}
