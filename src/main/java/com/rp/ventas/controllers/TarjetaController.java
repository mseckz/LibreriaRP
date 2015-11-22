package com.rp.ventas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rp.ventas.dao.models.TarjetaCredito;
import com.rp.ventas.service.interfaces.TablasMaestrasService;

@RestController
@RequestMapping("/tarjeta")
public class TarjetaController {
	
	@Autowired
	TablasMaestrasService servicio;
	
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public @ResponseBody List<TarjetaCredito> listarTarjetas() {
		List<TarjetaCredito> tarjetas = servicio.listarTarjetas();
		return tarjetas;
	}
}
