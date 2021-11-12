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

import com.evalbdp.model.Bien;
import com.evalbdp.repository.IBienRepository;


@RestController
@RequestMapping("/bienes")
public class RestBienController {

	@Autowired
	private IBienRepository repo;
	
	@GetMapping
	public List<Bien> listarBienes(){
		return repo.findAll();
	}
	
	@PostMapping
	public void insertarBienes(@RequestBody Bien bien){
		repo.save(bien);
	}
	
	@PutMapping
	public void actualizarBienes(@RequestBody Bien bien){
		 repo.save(bien);
	}
	
	@DeleteMapping(value="/{id}")
	public void eliminarBienes(@PathVariable("id") Integer id){
		 repo.deleteById(id);
	}
	
}
