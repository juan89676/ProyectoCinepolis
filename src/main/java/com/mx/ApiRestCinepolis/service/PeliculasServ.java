package com.mx.ApiRestCinepolis.service;

import java.util.List;

import com.mx.ApiRestCinepolis.model.Peliculas;

public interface PeliculasServ {
	public List<Peliculas> mostrarPeliculas();
	public boolean guardarPeliculas(Peliculas pelicula);
	public Peliculas buscarPelicula(Integer id);
	public boolean editarPelicula(Peliculas peliculas);
	public boolean eliminarPelicula(Integer id);
}
