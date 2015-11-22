package com.rp.ventas.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rp.ventas.dao.interfaces.LibroDAO;
import com.rp.ventas.dao.models.Libro;
import com.rp.ventas.service.interfaces.LibroService;

@Service	
public class LibroServiceImpl implements LibroService{

	@Autowired
	LibroDAO libroDAO;
	
	@Override
	@Transactional
	public void registrarLibro(Libro libro) {
		libroDAO.crear(libro);
	}

	@Override
	public List<Libro> listarLibros() {
		return libroDAO.obtenerPorEstado(true);
	}

}
