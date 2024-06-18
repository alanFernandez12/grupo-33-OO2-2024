package com.Grupo33.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Stock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStock;
	private int cantidad;
	private int cantidadMin;
	@OneToOne
	@JoinColumn(name = "producto_id")
	private Producto producto;
	private String almacen;
	
	public Stock(int cantidad, int cantidadMin, Producto producto) {
		super();
		this.cantidad = cantidad;
		this.cantidadMin = cantidadMin;
		this.producto = producto;
	}

	public Stock() {
		
	}
	
	
}
