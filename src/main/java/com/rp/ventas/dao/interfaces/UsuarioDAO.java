package com.rp.ventas.dao.interfaces;

import com.rp.ventas.dao.models.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario>{
	
	Usuario validarLogin(String correo, String clave);
}
