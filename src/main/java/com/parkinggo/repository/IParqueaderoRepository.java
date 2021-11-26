package com.parkinggo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkinggo.model.Parqueadero;

public interface IParqueaderoRepository extends JpaRepository<Parqueadero, Integer>{

}
