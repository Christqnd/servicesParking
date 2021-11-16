package com.parkinggo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parkinggo.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{

}
