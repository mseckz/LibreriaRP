package com.rp.ventas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rp.ventas.dao.models.Usuario;
import com.rp.ventas.service.interfaces.UsuarioService;

@RestController
@RequestMapping(value="/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Usuario> login(@RequestBody Usuario usuario){
		Usuario user = usuarioService.validarLogin(usuario.getCorreo(), usuario.getClave());
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST,consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE, MediaType.ALL_VALUE},
			 produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Void> registrar(@RequestBody Usuario usuario){
		usuarioService.registrarUsuario(usuario);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
