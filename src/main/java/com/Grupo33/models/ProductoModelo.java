package com.Grupo33.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoModelo {
	private int idProducto;
	
	private int codigo;
	
	private String nombre;
	
	private double precio;

	public ProductoModelo(int codigo, String nombre, double precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

	public ProductoModelo() {
		
	}

	@Override
	public String toString() {
		return "ProductoModelo [idProducto=" + idProducto + ", codigo=" + codigo + ", nombre=" + nombre + ", precio="
				+ precio + "]";
	}
	
	
}
