package com.parkinggo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkinggo.model.Empresa;


public interface IEmpresaRepository  extends JpaRepository<Empresa, Long>{

	List<Empresa> findByEstado(String estado);
}
