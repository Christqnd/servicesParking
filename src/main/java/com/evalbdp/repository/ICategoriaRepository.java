package com.evalbdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evalbdp.model.Categoria;

public interface ICategoriaRepository extends JpaRepository<Categoria, Integer> {

}
