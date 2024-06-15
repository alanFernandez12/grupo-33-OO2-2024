package com.Grupo33.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	
	private int codigo;
	
	private String nombre;
	private String descripcion;
	private String categoria;
	private double costo;
	private double precio;
	

	

	public Producto() {
		
	}




	public Producto(int codigo, String nombre, String descripcion, String categoria, double costo, double precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.costo = costo;
		this.precio = precio;
	}
	
	
}
