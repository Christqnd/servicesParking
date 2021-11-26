package com.parkinggo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StatePuerta")
public class StatePuerta {

	@Id
	@Column(name = "id_state_puerta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStatePuerta;

	@Column(name = "tipo", length = 100)
	private String tipo;

	public StatePuerta(String tipo) {
		super();
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getIdStatePuerta() {
		return idStatePuerta;
	}

	public void setIdStatePuerta(Long idStatePuerta) {
		this.idStatePuerta = idStatePuerta;
	}

	
}
