package com.parkinggo.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.parkinggo.model.Usuario;
import com.parkinggo.model.Vehiculo;
import com.parkinggo.repository.IUsuarioRepository;
import com.parkinggo.repository.IVehiculoRepository;

@RestController
@RequestMapping("/vehiculos")
public class RestVehiculoController {

	private final IUsuarioRepository repUsuario;
	private final IVehiculoRepository repVehiculo;

    @Autowired
    public RestVehiculoController(IUsuarioRepository repUsuario, IVehiculoRepository repVehiculo) {
        this.repUsuario = repUsuario;
        this.repVehiculo = repVehiculo;
    }
    
	@Autowired
	private IVehiculoRepository repo;
	
	@GetMapping
	public List<Vehiculo> listarVehiculos(){
		return repVehiculo.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Vehiculo> insertarVehiculo(@RequestBody Vehiculo vehiculo){
		   Optional<Usuario> optionalLibrary = repUsuario.findById(Integer.parseInt(vehiculo.getUsuario().getIdUsuario().toString()));
	        if (!optionalLibrary.isPresent()) {
	            return ResponseEntity.unprocessableEntity().build();
	        }

	        vehiculo.setUsuario(optionalLibrary.get());

	        Vehiculo savedVehicule = repVehiculo.save(vehiculo);
	        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id_usuario}")
	            .buildAndExpand(savedVehicule.getIdUsuario()).toUri();

	        return ResponseEntity.created(location).body(savedVehicule);
	        
//		repVehiculo.save(vehiculo);
	}
	
	@PutMapping
	public void actualizarVehiculo(@RequestBody Vehiculo vehiculo){
		repVehiculo.save(vehiculo);
	}
	
	@DeleteMapping(value="/{id}")
	public void eliminarVehiculo(@PathVariable("id") Integer id){
		repVehiculo.deleteById(id);
	}
	
}
