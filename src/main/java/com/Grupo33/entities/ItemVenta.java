package com.Grupo33.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ItemVenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idItemVenta;
	
	@ManyToOne
	@JoinColumn(name = "producto_id" , nullable = false)
	private Producto producto;

	private int cantidad;
	
	private double subPrecio;

    private LocalDate fecha;

	public ItemVenta() {
		
	}

	public ItemVenta(Producto producto, int cantidad, double subPrecio,LocalDate fecha) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.subPrecio = subPrecio;
		this.fecha= fecha;
	
	}
	
	
}
