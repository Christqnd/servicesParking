package com.parkinggo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkinggo.model.Vehiculo;

public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long>{

	List<Vehiculo> findByEstado(String estado);
	
	
	List<Vehiculo> findByEstadoAndUsuarioId(String estado,Long idUsuario);
	
}
