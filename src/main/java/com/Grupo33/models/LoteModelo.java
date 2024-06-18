package com.Grupo33.models;

import java.time.LocalDate;

import com.Grupo33.entities.Producto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoteModelo {

	private int idLote;	
	private Producto producto;	
	private String proveedor;
	private int cantidad;
	private LocalDate fechaRecepcion;
	private double precio;

	public LoteModelo(Producto producto, String proveedor, int cantidad, LocalDate fechaRecepcion, double precio) {
		super();
		this.producto = producto;
		this.proveedor = proveedor;
		this.cantidad = cantidad;
		this.fechaRecepcion = fechaRecepcion;
		this.precio = precio;
	}

	public LoteModelo() {
		
	}

	@Override
	public String toString() {
		return "LoteModelo [idLote=" + idLote + ", producto=" + producto.getNombre() + ", proveedor=" + proveedor + ", cantidad="
				+ cantidad + ", fechaRecepcion=" + fechaRecepcion + ", precio=" + precio + "]";
	}
	


}
