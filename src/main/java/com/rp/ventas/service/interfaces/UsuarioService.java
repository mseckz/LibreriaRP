package com.rp.ventas.service.interfaces;

import com.rp.ventas.dao.models.Usuario;

public interface UsuarioService {
	
	void registrarUsuario(Usuario usuario);
	
	Usuario validarLogin(String correo, String clave);
}
