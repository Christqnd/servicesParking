package com.parkinggo.rest;

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


import com.parkinggo.model.Parqueadero;
import com.parkinggo.repository.IParqueaderoRepository;


@RestController
@RequestMapping("/parqueaderos")
public class RestParqueaderoController {

	@Autowired
	private IParqueaderoRepository repo;

	@GetMapping
	public List<Parqueadero> listarParqueaderos() {
		return repo.findAll();
	}

	@PostMapping
	public void insertarParqueadero(@RequestBody Parqueadero parqueadero) {
		repo.save(parqueadero);
	}

	@PutMapping
	public void actualizarParqueadero(@RequestBody Parqueadero parqueadero) {
		repo.save(parqueadero);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminarParqueadero(@PathVariable("id") Long id) {
		repo.deleteById(id);
	}
}
