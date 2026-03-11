package com.mx.ApiRestCinepolis.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

}
