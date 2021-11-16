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

import com.parkinggo.model.Usuario;
import com.parkinggo.repository.IUsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class RestUsuarioController {

	@Autowired
	private IUsuarioRepository repo;
	
	@GetMapping
	public List<Usuario> listarUsuario(){
		return repo.findAll();
	}
	
	@PostMapping
	public void insertarUsuario(@RequestBody Usuario usuario){
		repo.save(usuario);
	}
	
	@PutMapping
	public void actualizarUsuario(@RequestBody Usuario usuario){
		 repo.save(usuario);
	}
	
	@DeleteMapping(value="/{id}")
	public void eliminarUsuario(@PathVariable("id") Integer id){
		 repo.deleteById(id);
	}
}
