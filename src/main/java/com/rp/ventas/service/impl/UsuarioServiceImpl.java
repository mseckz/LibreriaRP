package com.rp.ventas.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rp.ventas.dao.interfaces.UsuarioDAO;
import com.rp.ventas.dao.models.Usuario;
import com.rp.ventas.service.interfaces.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioDAO usuarioDAO;
	
	@Transactional
	@Override
	public void registrarUsuario(Usuario usuario) {
		usuarioDAO.crear(usuario);
	}

	@Override
	public Usuario validarLogin(String correo, String clave) {
		return usuarioDAO.validarLogin(correo, clave);
	}

}
