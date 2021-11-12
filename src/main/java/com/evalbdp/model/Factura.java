package com.evalbdp.model;

import java.util.Date;
import java.util.LinkedList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Factura")
public class Factura {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "tiempo", length = 100)
	@Temporal(TemporalType.DATE)
	private Date tiempo;
	@Column(name = "cedula", length = 100)
	private String cedula;
	@Column(name = "total")
	private double total;
	@Column(name = "subtotal")
	private double subtotal;
	@Column(name = "iva")
	private double iva;
	@OneToOne(mappedBy = "Factura", cascade = CascadeType.ALL)
	private StateFactura estadoFactura;
	@OneToMany(mappedBy = "Factura", cascade = CascadeType.ALL)
	private LinkedList<DetalleFactura> listaDetalleFacturas = new LinkedList<>();

	public Factura(Date tiempo, String cedula, double total, double subtotal, double iva, StateFactura estadoFactura,
			LinkedList<DetalleFactura> listaDetalleFacturas) {
		super();
		this.tiempo = tiempo;
		this.cedula = cedula;
		this.total = total;
		this.subtotal = subtotal;
		this.iva = iva;
		this.estadoFactura = estadoFactura;
		this.listaDetalleFacturas = listaDetalleFacturas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getTiempo() {
		return tiempo;
	}

	public void setTiempo(Date tiempo) {
		this.tiempo = tiempo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public StateFactura getEstadoFactura() {
		return estadoFactura;
	}

	public void setEstadoFactura(StateFactura estadoFactura) {
		this.estadoFactura = estadoFactura;
	}

	public LinkedList<DetalleFactura> getListaDetalleFacturas() {
		return listaDetalleFacturas;
	}

	public void setListaDetalleFacturas(LinkedList<DetalleFactura> listaDetalleFacturas) {
		this.listaDetalleFacturas = listaDetalleFacturas;
	}
	
}
