package com.parkinggo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Puerta")
public class Puerta {

	@Id
	@Column(name = "id_puerta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPuerta;

	@Column(name = "asignado")
	private boolean asignado = false;

	@Column(name = "numero", length = 100)
	private int numero;

	@Column(name = "codigo", length = 100)
	private String codigo;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "parqueadero_id", nullable = true, updatable = false)
	@JsonIgnore
	private Parqueadero parqueadero;

	// @OneToOne(mappedBy = "Puerta", cascade = CascadeType.ALL)
//    private Portero portero;
//
//	@OneToOne(mappedBy = "Puerta", cascade = CascadeType.ALL)
//	private StatePuerta tipoDePuerta;//tipo de puerta(Entrada,Salida,Entrada y Salida)	

	public Puerta(boolean asignado, int numero, String codigo) {
		super();
		this.asignado = asignado;
		this.numero = numero;
		this.codigo = codigo;
		this.parqueadero = new Parqueadero();
	}

	public Puerta() {
		super();
	}

	public Parqueadero getParqueadero() {
		return parqueadero;
	}

	public void setParqueadero(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}

	public Long getIdPuerta() {
		return idPuerta;
	}

	public void setIdPuerta(Long idPuerta) {
		this.idPuerta = idPuerta;
	}

	public boolean isAsignado() {
		return asignado;
	}

	public void setAsignado(boolean asignado) {
		this.asignado = asignado;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
//
//	public StatePuerta getTipoDePuerta() {
//		return tipoDePuerta;
//	}
//
//	public void setTipoDePuerta(StatePuerta tipoDePuerta) {
//		this.tipoDePuerta = tipoDePuerta;
//	}

}
