package com.evalbdp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author pc_hp
 *
 */
@Entity
@Table(name = "StateFactura")
public class StateFactura {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "estadoFactura", length = 100)
	public String estadoFactura;

	public StateFactura(Long id, String estadoFactura) {
		super();
		this.estadoFactura = estadoFactura;
	}

	public String getEstadoFactura() {
		return estadoFactura;
	}

	public void setEstadoFactura(String estadoFactura) {
		this.estadoFactura = estadoFactura;
	}

}
