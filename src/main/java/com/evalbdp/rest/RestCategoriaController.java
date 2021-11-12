package com.evalbdp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.evalbdp.model.Categoria;
import com.evalbdp.repository.ICategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class RestCategoriaController {

	
	@Autowired
	private ICategoriaRepository repo;
	
	@GetMapping
	public List<Categoria> listarCategorias(){
		return repo.findAll();
	}
	
	@PostMapping
	public void insertarCategorias(@RequestBody Categoria categoria){
		repo.save(categoria);
	}
	
	@PutMapping
	public void actualizarCategorias(@RequestBody Categoria categoria){
		 repo.save(categoria);
	}
	
	@DeleteMapping(value="/{id}")
	public void eliminarCategorias(@PathVariable("id") Integer id){
		 repo.deleteById(id);
	}
}
