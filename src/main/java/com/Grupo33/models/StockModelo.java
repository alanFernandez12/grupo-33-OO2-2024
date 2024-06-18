package com.Grupo33.models;

import com.Grupo33.entities.Producto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockModelo {
	private int idStock;
	private int cantidad;
	private int cantidadMin;
	private Producto producto;
	private String almacen;
	
	public StockModelo(int cantidad, int cantidadMin, Producto producto, String almacen) {
		super();
		this.cantidad = cantidad;
		this.cantidadMin = cantidadMin;
		this.producto = producto;
		this.almacen = almacen;
	}

	public StockModelo() {
		
	}
}
