package com.parkinggo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Puerta")
public class Puerta {

    @Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "asignado")
	private boolean asignado=false;
	@Column(name = "numero", length = 100)
    private int numero;
	@Column(name = "codigo", length = 100)
    private String Codigo;

//	@OneToOne(mappedBy = "Puerta", cascade = CascadeType.ALL)
//    private Portero portero;
//
//	@OneToOne(mappedBy = "Puerta", cascade = CascadeType.ALL)
//	private StatePuerta tipoDePuerta;//tipo de puerta(Entrada,Salida,Entrada y Salida)

//    @ManyToOne
//    @JoinColumn(name = "FK_INVOICE", nullable = false, updatable = false)
//    private Parqueadero parqueadero;
//	
    
//	public Parqueadero getParqueadero() {
//		return parqueadero;
//	}
//
//	public void setParqueadero(Parqueadero parqueadero) {
//		this.parqueadero = parqueadero;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
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
