package com.rp.ventas.dao.models;

public class DetalleVenta {

	private Integer idVenta;
	private Integer item;
	private Integer idLibro;
	private String nombreLibro;
	private Integer cantidad;
	private Double precioParcial;
	
	public Integer getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}
	public Integer getItem() {
		return item;
	}
	public void setItem(Integer item) {
		this.item = item;
	}
	public Integer getIdLibro() {
		return idLibro;
	}
	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}
	public String getNombreLibro() {
		return nombreLibro;
	}
	public void setNombreLibro(String nombreLibro) {
		this.nombreLibro = nombreLibro;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecioParcial() {
		return precioParcial;
	}
	public void setPrecioParcial(Double precioParcial) {
		this.precioParcial = precioParcial;
	}
	
	
}