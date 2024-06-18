package com.Grupo33.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Lote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLote;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_producto", nullable=false)
	private Producto producto;
	private String proveedor;
	private int cantidad;
	private LocalDate fechaRecepcion;
	private double precio;

	public Lote(Producto producto, String proveedor, int cantidad, LocalDate fechaRecepcion, double precio) {
		super();
		this.producto = producto;
		this.proveedor = proveedor;
		this.cantidad = cantidad;
		this.fechaRecepcion = fechaRecepcion;
		this.precio = precio;
	}

	public Lote() {
		
	}
	
	
}
