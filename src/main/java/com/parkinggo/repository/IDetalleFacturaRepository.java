package com.parkinggo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkinggo.model.DetalleFactura;

public interface IDetalleFacturaRepository extends JpaRepository<DetalleFactura, Long>{

}
