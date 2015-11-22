package com.rp.ventas.dao.impl;

import org.springframework.stereotype.Repository;

import com.rp.ventas.dao.interfaces.TarjetaCreditoDAO;
import com.rp.ventas.dao.models.TarjetaCredito;

@Repository
public class TarjetaDAOImpl extends GenericDAOImpl<TarjetaCredito> implements TarjetaCreditoDAO{
	
	public TarjetaDAOImpl(){
		setClazz(TarjetaCredito.class);
	}
}
