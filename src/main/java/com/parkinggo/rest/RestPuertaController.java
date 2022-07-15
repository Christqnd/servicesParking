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
import com.parkinggo.model.Puerta;
import com.parkinggo.repository.IParqueaderoRepository;
import com.parkinggo.repository.IPuertaRepository;

@RestController
@RequestMapping("/puertas")
public class RestPuertaController {

	@Autowired
	private IPuertaRepository repPuerta;
	private IParqueaderoRepository repParqueadero;
	

	@GetMapping
	public List<Puerta> listarPuerta() {
		return repPuerta.findAll();
	}

	
//	@PostMapping
//	public void insertaPuerta(@RequestBody Puerta puerta) {
//		repPuerta.save(puerta);
//	}

	@PostMapping
	public ResponseEntity<Puerta> insertarPuerta(@RequestBody Puerta puerta) {

		Optional<Parqueadero> parqueaderoOpt = repParqueadero.findById(puerta.getParqueadero().getIdParqueadero());
		if (!parqueaderoOpt.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		puerta.setParqueadero(parqueaderoOpt.get());
		
		Puerta savedDoor= repPuerta.save(puerta);
		URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedDoor.getIdPuerta()).toUri();
		
		LoggerFactory.getLogger(EvalbdpApplication.class).info("########## Se detecta ingreso");
		
		return ResponseEntity.created(location).body(savedDoor);
	}
	
	@PutMapping
	public void actualizarPuerta(@RequestBody Puerta puerta) {
		repPuerta.save(puerta);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminarPuerta(@PathVariable("id") Long id) {
		repPuerta.deleteById(id);
	}
}
