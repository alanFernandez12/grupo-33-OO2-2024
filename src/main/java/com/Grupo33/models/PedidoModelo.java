package com.Grupo33.models;

import com.Grupo33.entities.Producto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoModelo {

	private int idPedido;
	private Producto producto;
	private String proveedor;
	private int cantidad;
	
	public PedidoModelo(Producto producto, String proveedor, int cantidad) {
		super();
		this.producto = producto;
		this.proveedor = proveedor;
		this.cantidad = cantidad;
	}

	public PedidoModelo() {
		super();
	}
	
	
}
