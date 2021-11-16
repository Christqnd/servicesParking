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

import com.parkinggo.model.DetalleFactura;
import com.parkinggo.repository.IDetalleFacturaRepository;

@RestController
@RequestMapping("/detallefactura")
public class RestDetalleFacturaController {
	@Autowired
	private IDetalleFacturaRepository repo;

	@GetMapping
	public List<DetalleFactura> listarDetalleFactura() {
		return repo.findAll();
	}

	@PostMapping
	public void insertarDetalleFactura(@RequestBody DetalleFactura detallefactura) {
		repo.save(detallefactura);
	}

	@PutMapping
	public void actualizarDetalleFactura(@RequestBody DetalleFactura detallefactura) {
		repo.save(detallefactura);
	}

	@DeleteMapping(value = "/{id}")
	public void eliminarDetalleFactura(@PathVariable("id") Integer id) {
		repo.deleteById(id);
	}

}
