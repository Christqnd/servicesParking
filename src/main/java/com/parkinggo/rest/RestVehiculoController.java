package com.parkinggo.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.parkinggo.model.Usuario;
import com.parkinggo.model.Vehiculo;
import com.parkinggo.repository.IUsuarioRepository;
import com.parkinggo.repository.IVehiculoRepository;

//import javax.validation.Valid;  

@RestController
@RequestMapping("/vehiculos")
public class RestVehiculoController {

	private final IUsuarioRepository repUsuario;
	private final IVehiculoRepository repVehiculo;

	@Autowired
	public RestVehiculoController(IUsuarioRepository repUsuario, IVehiculoRepository repVehiculo) {
		this.repUsuario = repUsuario;
		this.repVehiculo = repVehiculo;
	}

	@Autowired
	private IVehiculoRepository repo;

	@GetMapping
	public List<Vehiculo> listarVehiculos() {
		return repVehiculo.findAll();
	}
	
	@GetMapping(value = "/activos")
	public ResponseEntity<List<Vehiculo>> listarUsuariosActivos() {
		List<Vehiculo> vehiculos = repVehiculo.findByEstado("A");
		return new ResponseEntity<>(vehiculos, HttpStatus.OK);
	}
	
	@GetMapping(value = "/vehiculos_usuario_activos/{id}")
	public ResponseEntity<List<Vehiculo>> listarVehiculosDeUsuarioActivos(@PathVariable Long id) {
		List<Vehiculo> vehiculos = repVehiculo.findByEstadoAndUsuarioId("A",Long.valueOf(id));
		return new ResponseEntity<>(vehiculos, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Vehiculo> recuperaVehiculo(@PathVariable Long id) {
		Optional<Vehiculo> vehiculoOpt = repVehiculo.findById(id);
		if (!vehiculoOpt.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		return ResponseEntity.ok(vehiculoOpt.get());
	}

	@PostMapping
	public ResponseEntity<Vehiculo> insertarVehiculo(@RequestBody Vehiculo vehiculo) {
		Optional<Usuario> usuarioOpt = repUsuario.findById(vehiculo.getUsuario().getId());
		if (!usuarioOpt.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		vehiculo.setUsuario(usuarioOpt.get());

		Vehiculo savedVehicule = repVehiculo.save(vehiculo);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedVehicule.getId()).toUri();

		
		LoggerFactory.getLogger(EvalbdpApplication.class).error("############# Exception catch : "+ savedVehicule.getId());

		return ResponseEntity.created(location).body(savedVehicule);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Vehiculo> actualizarVehiculo(@PathVariable("id") Long id, @RequestBody Vehiculo vehiculo) {

		Optional<Usuario> usuarioOpt = repUsuario.findById(vehiculo.getUsuario().getId());
		if (!usuarioOpt.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		Optional<Vehiculo> vehiculoOpt = repVehiculo.findById(id);
		if (!vehiculoOpt.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		vehiculo.setUsuario(usuarioOpt.get());
		vehiculo.setId(vehiculoOpt.get().getId());
		repVehiculo.save(vehiculo);

		return ResponseEntity.noContent().build();

	}

	@PutMapping(value = "vehiculo/{id}")
	public ResponseEntity<Vehiculo> actualizarVehiculoIndividual(@PathVariable("id") Long id,
			@RequestBody Vehiculo vehiculo) {

		Optional<Vehiculo> vehiculoOpt = repVehiculo.findById(id);
		Usuario usutemp;
		if (!vehiculoOpt.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}
		LoggerFactory.getLogger(EvalbdpApplication.class).error("############# id : " + vehiculo.getUsuario().getId());

		if (vehiculo.getUsuario().getId() != null) {
			Optional<Usuario> usuarioOpt = repUsuario.findById(vehiculo.getUsuario().getId());

			if (!usuarioOpt.isPresent()) {
				return ResponseEntity.unprocessableEntity().build();
			}
			usutemp = usuarioOpt.get();
		}else {
			usutemp= vehiculoOpt.get().getUsuario();
		}

//		vehiculo.setId(vehiculoOpt.get().getId());
		vehiculo.setUsuario(usutemp);

		repVehiculo.save(vehiculo);

		return ResponseEntity.noContent().build();

	}

	@PutMapping(value = "dvehiculo/{id}")
	public ResponseEntity<Usuario> desabilitarVehiculo(@PathVariable("id") Long id) {

		Optional<Vehiculo> vehiculoOpt = repVehiculo.findById(id);
		if (!vehiculoOpt.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		vehiculoOpt.get().setEstado("D");
		repVehiculo.save(vehiculoOpt.get());

		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "avehiculo/{id}")
	public ResponseEntity<Usuario> habilitarVehiculo(@PathVariable("id") Long id) {

		Optional<Vehiculo> vehiculoOpt = repVehiculo.findById(id);
		if (!vehiculoOpt.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		vehiculoOpt.get().setEstado("A");
		repVehiculo.save(vehiculoOpt.get());

		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminarVehiculo(@PathVariable("id") Long id) {
		repVehiculo.deleteById(id);
	}

}
