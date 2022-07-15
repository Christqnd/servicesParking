package com.parkinggo.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.parkinggo.EvalbdpApplication;
import com.parkinggo.model.Empresa;
import com.parkinggo.model.Parqueadero;
import com.parkinggo.model.Vehiculo;
import com.parkinggo.repository.IEmpresaRepository;
import com.parkinggo.repository.IParqueaderoRepository;

@RestController
@RequestMapping("/parqueaderos")
public class RestParqueaderoController {

	private IEmpresaRepository repEmpresa;
	private IParqueaderoRepository repParqueadero;

	@Autowired
	public RestParqueaderoController(IEmpresaRepository repEmpresa, IParqueaderoRepository repParqueadero) {
		this.repEmpresa = repEmpresa;
		this.repParqueadero = repParqueadero;
	}

	@GetMapping
	public List<Parqueadero> listarParqueaderos() {
		return repParqueadero.findAll();
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<Parqueadero> recuperaVehiculo(@PathVariable Long id) {
		Optional<Parqueadero> parqueaderoOpt = repParqueadero.findById(id);
		if (!parqueaderoOpt.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		return ResponseEntity.ok(parqueaderoOpt.get());
	}
	
	@PostMapping
	public ResponseEntity<Parqueadero> insertarParqueadero(@RequestBody Parqueadero parqueadero) {
		Optional<Empresa> empresaOpt = repEmpresa.findById(parqueadero.getEmpresa().getIdEmpresa());
		if (!empresaOpt.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		parqueadero.setEmpresa(empresaOpt.get());
		
		Parqueadero savedParking= repParqueadero.save(parqueadero);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedParking.getIdParqueadero()).toUri();
		
		LoggerFactory.getLogger(EvalbdpApplication.class).info("########## Se detecta ingreso");
		
		return ResponseEntity.created(location).body(savedParking);
	}

	@PutMapping
	public void actualizarParqueadero(@RequestBody Parqueadero parqueadero) {
		repParqueadero.save(parqueadero);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminarParqueadero(@PathVariable("id") Long id) {
		repParqueadero.deleteById(id);
	}
}
