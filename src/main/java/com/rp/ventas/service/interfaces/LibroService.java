package com.rp.ventas.service.interfaces;

import java.util.List;

import com.rp.ventas.dao.models.Libro;

public interface LibroService {
	
	void registrarLibro(Libro libro);
	
	List<Libro> listarLibros();
}
