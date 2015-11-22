package com.rp.ventas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rp.ventas.dao.models.Libro;
import com.rp.ventas.service.interfaces.LibroService;

@RestController
@RequestMapping("/libro")
public class LibroController {

	@Autowired
	private LibroService libroService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<Libro> listarLibros() {
		List<Libro> libros = libroService.listarLibros();
		return libros;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE, MediaType.ALL_VALUE},
			 produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> registrarLibro(@RequestBody Libro libro){
		libroService.registrarLibro(libro);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
