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

import com.parkinggo.model.Factura;
import com.parkinggo.repository.IFacturaRepository;

@RestController
@RequestMapping("/factura")
public class RestFacturaController {

	@Autowired
	private IFacturaRepository repo;

	@GetMapping
	public List<Factura> listarFactura() {
		return repo.findAll();
	}

	@PostMapping
	public void insertarFactura(@RequestBody Factura factura) {
		repo.save(factura);
	}

	@PutMapping
	public void actualizarFactura(@RequestBody Factura factura) {
		repo.save(factura);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminarFactura(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}
}
