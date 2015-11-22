package com.rp.ventas.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.rp.ventas.dao.interfaces.UsuarioDAO;
import com.rp.ventas.dao.models.Usuario;

@Repository
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements UsuarioDAO {

	public UsuarioDAOImpl(){
		setClazz(Usuario.class);
	}
	
	@Override
	public Usuario validarLogin(String correo, String clave) {
		String hql = "Select u from Usuario u where u.correo =:correo and u.clave =:clave";
		TypedQuery<Usuario> query = entityManager.createQuery(hql, Usuario.class);
		query.setParameter("correo", correo);
		query.setParameter("clave", clave);
		List<Usuario> resultado = query.getResultList();
		return resultado.isEmpty() ? null : resultado.get(0);
	}
	
}
