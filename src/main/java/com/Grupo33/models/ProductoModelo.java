package com.Grupo33.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoModelo {
	private int idProducto;
	
	private int codigo;
	
	private String nombre;
	private String descripcion;
	private String categoria;
	private double costo;
	private double precio;



	public ProductoModelo() {
		
	}

	@Override
	public String toString() {
		return "ProductoModelo [idProducto=" + idProducto + ", codigo=" + codigo + ", nombre=" + nombre + ", precio="
				+ precio + "]";
	}

	public ProductoModelo(int codigo, String nombre, String descripcion, String categoria, double costo,
			double precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.costo = costo;
		this.precio = precio;
	}
	
	
}
