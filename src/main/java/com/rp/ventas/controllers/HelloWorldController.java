package com.rp.ventas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rp.ventas.dao.interfaces.LibroDAO;
import com.rp.ventas.dao.models.Libro;

@Controller
@RequestMapping("/helloWorld")
public class HelloWorldController {
	
	@Autowired
	private LibroDAO libroDAO;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(ModelMap model) {
		model.addAttribute("msg", "JCG Hello World!");
		Libro libro = new Libro();
		libro.setNombreLibro("libro1");
		libro.setPrecio(20.0);
		libroDAO.grabar(libro);
		return "helloWorld";
	}
	
	@RequestMapping(value = "/displayMessage/{msg}", method = RequestMethod.GET)
	public String displayMessage(@PathVariable String msg, ModelMap model) {
		model.addAttribute("msg", msg);
		return "helloWorld";
	}
}
