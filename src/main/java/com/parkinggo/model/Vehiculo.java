package com.parkinggo.model;

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
public class Vehiculo {

	@Id
	@Column(name = "id_vehiculo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVehiculo;

	@Column(name = "placa", length = 20)
	private String placa;

	@Column(name = "marca", length = 100)
	private String marca;

	@Column(name = "modelo", length = 100)
	private String modelo;

	@Column(name = "observacion", length = 500)
	private String observacion;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(foreignKey = @ForeignKey(name = "usuario_id"),name = "usuario_id", nullable = false)
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
		this.usuario = new Usuario();
//		this.detallefactura = new DetalleFactura();
	}

	public Vehiculo() {
		super();
		this.placa = "";
		this.marca = "";
		this.modelo = "";
		this.observacion = "";
		this.usuario = new Usuario();
	}

	public Long getIdUsuario() {
		return idVehiculo;
	}

	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public Long getIdVehiculo() {
		return idVehiculo;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

//	public DetalleFactura getDetallefactura() {
//		return detallefactura;
//	}
//
//	public void setDetallefactura(DetalleFactura detallefactura) {
//		this.detallefactura = detallefactura;
//	}

}
