package com.parkinggo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkinggo.model.Factura;

public interface IFacturaRepository extends JpaRepository<Factura, Long>{

}
