package com.rp.ventas.dao.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.rp.ventas.dao.models.DetalleVenta.DetalleVentaPK;

@Entity
@Table(name="detalleventa")
@IdClass(DetalleVentaPK.class)
public class DetalleVenta implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="idVenta")
	private Integer idVenta;
	
	@Id
	@Column(name="item")
	private Integer item;
	
	@JoinColumn(name="idLibro")
	private Integer idLibro;
	
	@Column(name="nombreLibro")
	private String nombreLibro;
	
	@Column(name="cantidad")
	private Integer cantidad;
	
	@Column(name="precioParcial")
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
	
	
	public static class DetalleVentaPK implements Serializable{
		
		private static final long serialVersionUID = 1L;
		
		protected Integer idVenta;
		protected Integer item;
		
		public DetalleVentaPK(){}
		
		public DetalleVentaPK(Integer idVenta, Integer item){
			this.idVenta = idVenta;
			this.item = item;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result
					+ ((idVenta == null) ? 0 : idVenta.hashCode());
			result = prime * result + ((item == null) ? 0 : item.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DetalleVentaPK other = (DetalleVentaPK) obj;
			if (idVenta == null) {
				if (other.idVenta != null)
					return false;
			} else if (!idVenta.equals(other.idVenta))
				return false;
			if (item == null) {
				if (other.item != null)
					return false;
			} else if (!item.equals(other.item))
				return false;
			return true;
		}
		
	}
	
}