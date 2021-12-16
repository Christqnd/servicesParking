package com.parkinggo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "vehiculo")
public class Vehiculo implements Serializable{

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "placa", length = 20)
	private String placa;

	@Column(name = "marca", length = 100)
	private String marca;

	@Column(name = "modelo", length = 100)
	private String modelo;

	@Column(name = "observacion", length = 500)
	private String observacion;

	@Column(name = "estado", length = 1)
	private String estado;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(foreignKey = @ForeignKey(name = "usuario_id"),name = "usuario_id", nullable = true)
//	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@JsonIgnore private Usuario usuario;

//	@OneToOne(mappedBy = "vehiculo")
//	@JsonIgnore private DetalleFactura detallefactura;

	public Vehiculo(String placa, String marca, String modelo, String observacion) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.observacion = observacion;
		this.estado="A";
		this.usuario = new Usuario();
//		this.detallefactura = new DetalleFactura();
	}

	public Vehiculo() {
		super();
		this.placa = "";
		this.marca = "";
		this.modelo = "";
		this.observacion = "";
		this.estado="A";
		this.usuario = new Usuario();
	}


	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	
	public void setIdUsuario(Long id) {
		 usuario.setId(id);
	}

	public Long getIdUsuario() {
		return usuario.getId();
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


	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	
//	public DetalleFactura getDetallefactura() {
//		return detallefactura;
//	}
//
//	public void setDetallefactura(DetalleFactura detallefactura) {
//		this.detallefactura = detallefactura;
//	}

}
