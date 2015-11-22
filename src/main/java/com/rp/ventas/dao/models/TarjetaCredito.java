package com.rp.ventas.dao.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tarjetacredito")
public class TarjetaCredito implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue
	@Column(name="idTarjeta")
	private Integer idTarjeta;
	
	@Column(name="nombreTarjeta")
	private String nombreTarjeta;
	
	
	public Integer getIdTarjeta() {
		return idTarjeta;
	}
	public void setIdTarjeta(Integer idTarjeta) {
		this.idTarjeta = idTarjeta;
	}
	public String getNombreTarjeta() {
		return nombreTarjeta;
	}
	public void setNombreTarjeta(String nombreTarjeta) {
		this.nombreTarjeta = nombreTarjeta;
	}
	
}
