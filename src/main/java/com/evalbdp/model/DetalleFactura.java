package com.evalbdp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "DetalleFactura")
public class DetalleFactura {

    @Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Column(name ="fechaHoraEntrada", length=100)
    @Temporal(TemporalType.DATE)
    private Date fechaHoraEntrada;
    @Column(name ="fechaHoraSalida", length=100)
    @Temporal(TemporalType.DATE)
    private Date fechaHoraSalida;
    @Column(name ="tiempo", length=100)
    private String tiempo;
	
    
    public DetalleFactura(Date fechaHoraEntrada, Date fechaHoraSalida, String tiempo) {
		super();
		this.fechaHoraEntrada = fechaHoraEntrada;
		this.fechaHoraSalida = fechaHoraSalida;
		this.tiempo = tiempo;
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
    
}
