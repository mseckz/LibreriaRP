package com.rp.ventas.dao.interfaces;

import java.util.List;

import com.rp.ventas.dao.models.Libro;

public interface LibroDAO {
	
	void grabar(Libro libro);
	
	Libro buscarPorId(Integer id);
	
	List<Libro> listarLibros();
}
