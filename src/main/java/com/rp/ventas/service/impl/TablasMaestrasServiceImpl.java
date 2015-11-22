package com.rp.ventas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rp.ventas.dao.interfaces.TarjetaCreditoDAO;
import com.rp.ventas.dao.models.TarjetaCredito;
import com.rp.ventas.service.interfaces.TablasMaestrasService;

@Service
public class TablasMaestrasServiceImpl implements TablasMaestrasService{
	
	@Autowired
	TarjetaCreditoDAO tarjetaDAO;
	
	@Override
	public List<TarjetaCredito> listarTarjetas() {
		return tarjetaDAO.obtenerTodos();
	}

}
