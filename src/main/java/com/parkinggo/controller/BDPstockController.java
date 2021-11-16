package com.parkinggo.controller;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.parkinggo.EvalbdpApplication;
import com.parkinggo.model.Categoria;
import com.parkinggo.model.DetalleFactura;
import com.parkinggo.model.Factura;
import com.parkinggo.model.Usuario;
import com.parkinggo.model.Vehiculo;
import com.parkinggo.repository.IDetalleFacturaRepository;
import com.parkinggo.repository.IFacturaRepository;
import com.parkinggo.repository.IUsuarioRepository;
import com.parkinggo.repository.IVehiculoRepository;

@Controller
public class BDPstockController {

//	@Autowired
//	private IBienRepository repobn;
//
//	@Autowired
//	private ICategoriaRepository repoct;

	@Autowired
	private IUsuarioRepository repous;

	@Autowired
	private IVehiculoRepository repovh;

	@Autowired
	private IFacturaRepository repofc;
	
	@Autowired
	private IDetalleFacturaRepository repodf;

	@GetMapping("/start")
	public String Inicio() {
		
		/*
		 * Categoria categoria1=new Categoria("Desarrollo"); Categoria categoria2=new
		 * Categoria("Ejecutivo"); Categoria categoria3=new Categoria("Gerencia");
		 * 
		 * Bien bien=new
		 * Bien("Mesa","Mesa de madera con seguro de reconocimiento de huella dactilar"
		 * ); bien.addCategoria(categoria1); repobn.save(bien);
		 * 
		 * Bien bien2=new Bien("Silla","Silla giratoria");
		 * bien2.addCategoria(categoria1); repobn.save(bien2);
		 * 
		 * Bien bien3=new Bien("Teclado","Teclado mecanito inalambrico");
		 * bien3.addCategoria(categoria1); repobn.save(bien3);
		 */
		try {

			List<DetalleFactura> detallesfactura = new LinkedList<DetalleFactura>();
			DetalleFactura detalle1 = new DetalleFactura(
					new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("31/11/2021 12:12:12"),
					new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("31/11/2021 12:58:50"), "2:23:00");

			DetalleFactura detalle2 = new DetalleFactura(
					new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("05/12/2021 09:12:12"),
					new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("05/12/2021 15:58:50"), "4:23:00");

			DetalleFactura detalle3 = new DetalleFactura(
					new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("06/12/2021 13:12:12"),
					new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("06/12/2021 13:58:50"), "1:23:00");

			Factura factura = new Factura("25:25:12", "0102365458", 12.54, 12.52, 0.00);



			List<Vehiculo> vehiculos = new LinkedList<Vehiculo>();
			Vehiculo vehiculo = new Vehiculo("PXR-0248", "VW", "auto 2002");
			Usuario usuario = new Usuario("Christian Manuel", "Quinde Tenemaza", "0105783187", "0982651393");
			vehiculo.setUsuario(usuario);
			vehiculos.add(vehiculo);
			usuario.addVehiculo(vehiculo);

			repous.saveAndFlush(usuario);

			detalle1.setFactura(factura);
			vehiculo.setDetallefactura(detalle1);
			detalle1.setVehiculo(vehiculo);
			detallesfactura.add(detalle1);
			
			detalle2.setFactura(factura);
			vehiculo.setDetallefactura(detalle2);
			detalle2.setVehiculo(vehiculo);
			detallesfactura.add(detalle2);
			
			detalle3.setFactura(factura);
			vehiculo.setDetallefactura(detalle3);
			detalle3.setVehiculo(vehiculo);
			detallesfactura.add(detalle3);
			
			factura.setListaDetalleFacturas(detallesfactura);


			repofc.saveAndFlush(factura);

		} catch (Exception e) {
			LoggerFactory.getLogger(EvalbdpApplication.class).error("############# Exception catch : ");
			
		}
		return "start";

	}

}