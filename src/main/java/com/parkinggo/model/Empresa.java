package com.parkinggo.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

	@Id
	@Column(name = "id_empresa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmpresa;

	@Column(name = "codigo", length = 100)
	private String codigo;

	@Column(name = "nombre", length = 100)
	private String nombre;

	@Column(name = "descripcion", length = 500)
	private String descripcion;

	@Column(name = "propietario", length = 500)
	private String propietario;

	@Column(name = "estado", length = 1)
	private String estado;

	@Column(name = "fechacreacion")
	private Date fechaCreacion;

	@OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Parqueadero> parqueaderos;

	public Empresa(String codigo, String nombre, String descripcion, String propietario, String estado,
			LocalDateTime fechaCreacion, List<Parqueadero> parqueaderos) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.propietario = propietario;
		this.estado = "A";
		this.fechaCreacion = new Date();
		this.parqueaderos = new LinkedList<Parqueadero>();
	}

	public Empresa(String codigo, String nombre, String descripcion, String propietario, String estado) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.propietario = propietario;
		this.estado = "A";
		this.fechaCreacion = new Date();
		this.parqueaderos = new LinkedList<Parqueadero>();
	}

	public Empresa() {
		super();
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
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

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public List<Parqueadero> getParqueaderos() {
		return parqueaderos;
	}

	public void setParqueaderos(List<Parqueadero> parqueaderos) {
		for(Parqueadero p: parqueaderos) {
			p.setEmpresa(this);
		}
		this.parqueaderos = parqueaderos;
	}

}
