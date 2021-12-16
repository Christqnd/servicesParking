package com.parkinggo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkinggo.model.Empresa;

public interface IEmpresaRepository  extends JpaRepository<Empresa, Long>{

}
