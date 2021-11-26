package com.parkinggo.model;

import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "factura")
public class Factura {

	@Id
	@Column(name = "id_factura")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFactura;
	@Column(name = "tiempo", length = 100)
	private String tiempo;
	@Column(name = "cedula", length = 100)
	private String cedula;
	@Column(name = "total")
	private double total;
	@Column(name = "subtotal")
	private double subtotal;
	@Column(name = "iva")
	private double iva;

//	@OneToOne(mappedBy = "factura", cascade = CascadeType.ALL)
//	private StateFactura estadoFactura;

	@OneToMany(mappedBy = "factura", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DetalleFactura> listaDetalleFacturas;

	public Factura(String tiempo, String cedula, double total, double subtotal, double iva) {
		super();
		this.tiempo = tiempo;
		this.cedula = cedula;
		this.total = total;
		this.subtotal = subtotal;
		this.iva = iva;
//		this.estadoFactura = estadoFactura;
		this.listaDetalleFacturas = new LinkedList<DetalleFactura>();
	}
	

	public Factura() {
		super();
	}


	public Long getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(Long idFactura) {
		this.idFactura = idFactura;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
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

//	public StateFactura getEstadoFactura() {
//		return estadoFactura;
//	}
//
//	public void setEstadoFactura(StateFactura estadoFactura) {
//		this.estadoFactura = estadoFactura;
//	}

	public List<DetalleFactura> getListaDetalleFacturas() {
		return listaDetalleFacturas;
	}

	public void setListaDetalleFacturas(List<DetalleFactura> listaDetalleFacturas) {
		this.listaDetalleFacturas = listaDetalleFacturas;
	}

}
