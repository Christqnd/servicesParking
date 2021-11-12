package com.evalbdp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "Bien")
public class Bien {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name ="nombre", length=100)
	private String nombre;
	@Column(name ="descripcion", length=1000)
	private String descripcion;

	
    @JoinTable(
            name = "rel_bien_categoria",
            joinColumns = @JoinColumn(name = "FK_Bien", nullable = false),
            inverseJoinColumns = @JoinColumn(name="FK_Categoria", nullable = false)
        )
        @ManyToMany(cascade = CascadeType.ALL)
        private List<Categoria> categorias;
       
        public void addCategoria(Categoria categoria){
            if(this.categorias == null){
                this.categorias = new ArrayList<>();
            }
            
            this.categorias.add(categoria);
        }
	
	
	public Bien() {
	
	}
	
	public Bien( String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}


	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
