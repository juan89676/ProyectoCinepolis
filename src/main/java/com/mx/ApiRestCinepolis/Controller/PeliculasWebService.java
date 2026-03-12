package com.mx.ApiRestCinepolis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.ApiRestCinepolis.model.Peliculas;
import com.mx.ApiRestCinepolis.service.PeliculasServImplem;


@RestController
@RequestMapping(path = "ap1/v1")
@CrossOrigin
public class PeliculasWebService {
@Autowired
PeliculasServImplem peliculasServImplem;

//http://localhost:9000/ap1/v1/mostrarPeliculas
@GetMapping(path = "mostrarPeliculas")
public List<Peliculas> mostrarPeliculas(){
	return peliculasServImplem.mostrarPeliculas();
	
}

// http://localhost:9000/ap1/v1/guardarPeli
@PostMapping(path = "guardarPeli")
public ResponseEntity<?> guardarPeliculas(@RequestBody Peliculas pelicula){
	try {
		boolean response = peliculasServImplem.guardarPeliculas(pelicula);
		
		if(response == true)
			return new ResponseEntity<String>("No se guardo ya existe esa pelicula", HttpStatus.OK);
		else
			return new ResponseEntity<Peliculas>(pelicula, HttpStatus.CREATED);
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<String>("Error al guardar" + e.getMessage(), HttpStatus.OK);
	}
}

//http://localhost:9000/ap1/v1/buscarPeli
@PostMapping(path = "buscarPeli")
public ResponseEntity<?> buscar(@RequestBody Peliculas pelicula){
	Peliculas peliEncontrada = peliculasServImplem.buscarPelicula(pelicula.getIdPelicula());
	
	if(peliEncontrada == null)
		return new ResponseEntity<String>("No existe ese registro", HttpStatus.OK);
	else
		return new ResponseEntity<Peliculas>(peliEncontrada, HttpStatus.OK);
		
}
@PutMapping(path = "editarPeli")
//http://localhost:9000/ap1/v1/editarPeli
public ResponseEntity<?> editar(@RequestBody Peliculas pelicula){
	
	try {
		boolean response = peliculasServImplem.editarPelicula(pelicula);
		
		if(response == false)
			return new ResponseEntity<String>("No existe ese registro para editar", HttpStatus.OK);
		else
			return new ResponseEntity<Peliculas>(pelicula, HttpStatus.CREATED);
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<String>("Error al editar" + e.getMessage(), HttpStatus.OK);
	}
		
}

@PostMapping(path = "eliminarPeli")
//http://localhost:9000/ap1/v1/eliminarPeli
public ResponseEntity<?> eliminar(@RequestBody Peliculas pelicula){
	
	try {
		boolean response = peliculasServImplem.eliminarPelicula(pelicula.getIdPelicula());
		
		if(response == false)
			return new ResponseEntity<String>("No existe ese registro para eliminar", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Se elimino correctamente", HttpStatus.OK);
	} catch (Exception e) {
		// TODO: handle exception
		return new ResponseEntity<String>("Error al eliminar" + e.getMessage(), HttpStatus.OK);
	}
		
}

}
