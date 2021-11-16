package com.parkinggo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "detalle_factura")
public class DetalleFactura {

	@Id
	@Column(name = "id_detalle_factura")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDetalleFactura;

	@Column(name = "fechaHoraEntrada", length = 100)
	@Temporal(TemporalType.DATE)
	private Date fechaHoraEntrada;

	@Column(name = "fechaHoraSalida", length = 100)
	@Temporal(TemporalType.DATE)
	private Date fechaHoraSalida;

	@Column(name = "tiempo", length = 100)
	private String tiempo;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "factura_id", nullable = false, updatable = false)
	private Factura factura;

	@OneToOne // (mappedBy = "vehiculo_id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "vehiculo_id")
	private Vehiculo vehiculo;

	public DetalleFactura(Date fechaHoraEntrada, Date fechaHoraSalida, String tiempo) {
		super();
		this.fechaHoraEntrada = fechaHoraEntrada;
		this.fechaHoraSalida = fechaHoraSalida;
		this.tiempo = tiempo;
	}

	public Long getIdDetalleFactura() {
		return idDetalleFactura;
	}

	public void setIdDetalleFactura(Long idDetalleFactura) {
		this.idDetalleFactura = idDetalleFactura;
	}

	public Date getFechaHoraEntrada() {
		return fechaHoraEntrada;
	}

	public void setFechaHoraEntrada(Date fechaHoraEntrada) {
		this.fechaHoraEntrada = fechaHoraEntrada;
	}

	public Date getFechaHoraSalida() {
		return fechaHoraSalida;
	}

	public void setFechaHoraSalida(Date fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}
}
