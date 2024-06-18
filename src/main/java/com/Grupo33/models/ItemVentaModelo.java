package com.Grupo33.models;

import com.Grupo33.entities.Producto;
import com.Grupo33.entities.Venta;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemVentaModelo {
	
 
	private int idItemVenta;
	

	private Producto producto;

	private int cantidad;
	
	private double subPrecio;

 

	public ItemVentaModelo() {
		
	}

	public ItemVentaModelo(Producto producto, int cantidad, double subPrecio, Venta venta) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.subPrecio = subPrecio;

	}
	
}