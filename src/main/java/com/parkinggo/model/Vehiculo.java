package com.parkinggo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;
//    @ManyToMany(mappedBy = "Vehiculo")
//    private List<Bien> bienes;

    @OneToOne(mappedBy = "vehiculo")
    private DetalleFactura detallefactura;
    
    
	public DetalleFactura getDetallefactura() {
		return detallefactura;
	}

	public void setDetallefactura(DetalleFactura detallefactura) {
		this.detallefactura = detallefactura;
	}

	public Vehiculo(String placa, String marca, String modelo) {
		super();
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
//		this.usuario = usuario;
	}

	public Vehiculo() {
		super();
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

}
