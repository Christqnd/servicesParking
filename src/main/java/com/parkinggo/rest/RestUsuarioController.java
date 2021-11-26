package com.parkinggo.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.parkinggo.model.Usuario;
import com.parkinggo.repository.IUsuarioRepository;
import com.parkinggo.repository.IVehiculoRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/usuarios")
public class RestUsuarioController {

	private final IUsuarioRepository repUsuario;
	private final IVehiculoRepository repVehiculo;

    @Autowired
    public RestUsuarioController(IUsuarioRepository repUsuario, IVehiculoRepository repVehiculo) {
        this.repUsuario = repUsuario;
        this.repVehiculo = repVehiculo;
    }
	
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listarUsuario() {
		List<Usuario> users = repUsuario.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Usuario> insertarUsuario(@RequestBody Usuario usuario) {

		 Usuario savedUser = repUsuario.save(usuario);
		    URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id_usuario}")
		        .buildAndExpand(savedUser.getIdUsuario()).toUri();

		    return ResponseEntity.created(location).body(savedUser);
	}

	@PutMapping
	public ResponseEntity<Usuario> actualizarUsuario(@RequestBody Usuario usuario) {
		Usuario user = repUsuario.save(usuario);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> eliminarUsuario(@PathVariable("id") Integer id) {
		repUsuario.deleteById(id);
		return new ResponseEntity<>("Usuario con ID :" + id + " eliminado correctamente", HttpStatus.OK);
	}
}
