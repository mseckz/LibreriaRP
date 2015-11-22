package com.rp.ventas.dao.interfaces;

import java.util.List;

public interface GenericDAO <T> {
	
	T crear(T entitiy);
	List<T> obtenerTodos();
	List<T> obtenerPorEstado(boolean estado);
	void modificar(T entity);
}
