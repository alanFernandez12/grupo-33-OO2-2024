package com.Grupo33.entities;

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
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedido;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_producto", nullable=false)
	private Producto producto;
	private String proveedor;
	private int cantidad;
	
	public Pedido(Producto producto, String proveedor, int cantidad) {
		super();
		this.producto = producto;
		this.proveedor = proveedor;
		this.cantidad = cantidad;
	}
	public Pedido() {
		
	}
	
	
}
