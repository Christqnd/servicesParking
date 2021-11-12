package com.evalbdp.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@OneToOne(mappedBy = "Puerta", cascade = CascadeType.ALL)
	private StatePuerta tipoDePuerta;//tipo de puerta(Entrada,Salida,Entrada y Salida)
	

}
