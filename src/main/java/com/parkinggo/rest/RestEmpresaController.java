package com.parkinggo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parkinggo.model.Empresa;
import com.parkinggo.repository.IEmpresaRepository;

@RestController
@RequestMapping("/empresas")
public class RestEmpresaController {

	@Autowired
	private IEmpresaRepository repo;

	@GetMapping
	public List<Empresa> listarEmpresas() {
		return repo.findAll();
	}

	@PostMapping
	public void insertarEmpresa(@RequestBody Empresa empresa) {
		repo.save(empresa);
	}

	@PutMapping
	public void actualizarEmpresa(@RequestBody Empresa empresa) {
		repo.save(empresa);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminarEmpresa(@PathVariable("id") Long id) {
		repo.deleteById(id);
	}
}
