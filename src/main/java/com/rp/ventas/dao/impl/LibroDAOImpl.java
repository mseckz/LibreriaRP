package com.rp.ventas.dao.impl;

import org.springframework.stereotype.Repository;

import com.rp.ventas.dao.interfaces.LibroDAO;
import com.rp.ventas.dao.models.Libro;

@Repository
public class LibroDAOImpl extends GenericDAOImpl<Libro> implements LibroDAO{
	
	public LibroDAOImpl(){
		setClazz(Libro.class);
	}
}
