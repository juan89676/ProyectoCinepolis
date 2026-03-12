package com.mx.ApiRestCinepolis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.ApiRestCinepolis.dao.PeliculasDao;
import com.mx.ApiRestCinepolis.model.Peliculas;
@Service
public class PeliculasServImplem implements PeliculasServ{
	@Autowired 
	PeliculasDao peliculaDao;
	@Transactional(readOnly = true)
	
	@Override
	public List<Peliculas> mostrarPeliculas() {
		// TODO Auto-generated method stub
		List<Peliculas> listaPeliculas = peliculaDao.findAll();
		return listaPeliculas;
	}

	@Override
	public boolean guardarPeliculas(Peliculas pelicula) {
		// TODO Auto-generated method stub
		boolean bandera = false;
		for(Peliculas p: mostrarPeliculas()) {
			if(p.getNombre().equalsIgnoreCase(pelicula.getNombre())) {
			bandera = true;
			break;
			}
		}
		if(!bandera)
			peliculaDao.save(pelicula);
		return bandera;
	}

	@Override
	public Peliculas buscarPelicula(Integer id) {
		// TODO Auto-generated method stub
	Peliculas peliEncontrada = peliculaDao.findById(id).orElse(null);
		return peliEncontrada;
	}

	@Override
	public boolean editarPelicula(Peliculas peliculas) {
		// TODO Auto-generated method stub
		if(buscarPelicula(peliculas.getIdPelicula()) !=null) {
			peliculaDao.save(peliculas);
			return true;
		}
		else
			return false;
		
	
	}

	@Override
	public boolean eliminarPelicula(Integer id) {
		// TODO Auto-generated method stub

		if(buscarPelicula(id) != null) {
			peliculaDao.deleteById(id);
			return true;
		}
		else
			return false;
		
	
	}

}
