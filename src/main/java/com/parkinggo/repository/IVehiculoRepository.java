package com.parkinggo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkinggo.model.Vehiculo;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Integer>{

}
