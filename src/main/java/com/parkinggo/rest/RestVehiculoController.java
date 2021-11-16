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

import com.parkinggo.model.Vehiculo;
import com.parkinggo.repository.IVehiculoRepository;

@RestController
@RequestMapping("/vehiculos")
public class RestVehiculoController {

	@Autowired
	private IVehiculoRepository repo;
	
	@GetMapping
	public List<Vehiculo> listarVehiculos(){
		return repo.findAll();
	}
	
	@PostMapping
	public void insertarVehiculo(@RequestBody Vehiculo vehiculo){
		repo.save(vehiculo);
	}
	
	@PutMapping
	public void actualizarVehiculo(@RequestBody Vehiculo vehiculo){
		 repo.save(vehiculo);
	}
	
	@DeleteMapping(value="/{id}")
	public void eliminarVehiculo(@PathVariable("id") Integer id){
		 repo.deleteById(id);
	}
	
}
