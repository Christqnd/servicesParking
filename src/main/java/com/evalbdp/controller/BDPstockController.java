package com.evalbdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.evalbdp.model.Bien;
import com.evalbdp.model.Categoria;
import com.evalbdp.repository.IBienRepository;
import com.evalbdp.repository.ICategoriaRepository;

@Controller
public class BDPstockController {

	@Autowired
	private IBienRepository repobn;

	@Autowired
	private ICategoriaRepository repoct;


	@GetMapping("/start")
	public String Bienes() {

		Categoria categoria1=new Categoria("Desarrollo");
		Categoria categoria2=new Categoria("Ejecutivo");
		Categoria categoria3=new Categoria("Gerencia");
		
		Bien bien=new Bien("Mesa","Mesa de madera con seguro de reconocimiento de huella dactilar");
		bien.addCategoria(categoria1);
		repobn.save(bien);
		
		Bien bien2=new Bien("Silla","Silla giratoria");
		bien2.addCategoria(categoria1);
		repobn.save(bien2);
		
		Bien bien3=new Bien("Teclado","Teclado mecanito inalambrico");
		bien3.addCategoria(categoria1);
		repobn.save(bien3);



		return "start";
		
	}

}
