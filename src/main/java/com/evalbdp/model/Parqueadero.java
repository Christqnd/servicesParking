package com.evalbdp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Parqueadero")
public class Parqueadero {

    @Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "codigo", length = 100)
	private String codigo;
    
	@Column(name = "numero", length = 100)
	private int numero;    
	@Column(name = "capacidad", length = 100)
    private int capacidad;
	@Column(name = "ocupados", length = 100)
    private int ocupados;
    
//    private List<Puerta> puertas=new ArrayList();

}
