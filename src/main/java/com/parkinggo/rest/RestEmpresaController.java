package com.parkinggo.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.parkinggo.model.Empresa;
import com.parkinggo.repository.IEmpresaRepository;

@RestController
@RequestMapping("/empresas")
public class RestEmpresaController {

	
	@Autowired
	private IEmpresaRepository repEmpresa;

	@GetMapping
	public List<Empresa> listarEmpresas() {
		return repEmpresa.findAll();
	}
	
	@GetMapping(value = "/activas")
	public ResponseEntity<List<Empresa>> listarEmpresasActivos() {
		List<Empresa> empresas = repEmpresa.findByEstado("A");
		return new ResponseEntity<>(empresas, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Empresa> recuperaEmpresa(@PathVariable("id") Long id) {

		Optional<Empresa> empresaOpt = repEmpresa.findById(id);

		if (!empresaOpt.isPresent()) {
			return ResponseEntity.unprocessableEntity().build();
		}

		return new ResponseEntity<>(empresaOpt.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Empresa> insertarEmpresa(@RequestBody Empresa empresa) {
		
		Empresa empresaNew = repEmpresa.save(empresa);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(empresaNew.getIdEmpresa())
				.toUri();
		
		return ResponseEntity.created(location).body(empresaNew);
	}

	@PutMapping
	public void actualizarEmpresa(@RequestBody Empresa empresa) {
		repEmpresa.save(empresa);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminarEmpresa(@PathVariable("id") Long id) {
		repEmpresa.deleteById(id);
	}
}
