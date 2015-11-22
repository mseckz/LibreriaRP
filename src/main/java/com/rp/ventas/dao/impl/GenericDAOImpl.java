package com.rp.ventas.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.rp.ventas.dao.interfaces.GenericDAO;

public class GenericDAOImpl<T extends Serializable> implements GenericDAO<T> {

	protected Class<T> clazz;
	
	@PersistenceContext
    protected EntityManager entityManager;
	
	public final void setClazz(final Class<T> clazz) {
        this.clazz = clazz;
    }
	
	@Override
	public T crear(final T entitiy) {
		entityManager.persist(entitiy);
		return entitiy;
	}

	@Override
	public List<T> obtenerTodos() {
		TypedQuery<T> query = entityManager.createQuery("Select t from " + clazz.getSimpleName() + " t", clazz);
		return query.getResultList();
	}

	@Override
	public List<T> obtenerPorEstado(boolean estado) {
		TypedQuery<T> query = entityManager.createQuery("Select t from " + clazz.getSimpleName() + " t where t.estado =:estado", clazz);
		query.setParameter("estado", estado);
		return query.getResultList();
	}

	@Override
	public void modificar(T entity) {
		entityManager.merge(entity);
	}

}
