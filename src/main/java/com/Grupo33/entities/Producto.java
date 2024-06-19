package com.Grupo33.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL , orphanRemoval = true)
	private Set<Lote> lotes = new HashSet<>();	
	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Pedido> pedidos = new HashSet<>();


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




	@Override
	public int hashCode() {
		return Objects.hash(idProducto);
	}




	@Override
	public boolean equals(Object obj) {
		Producto other = (Producto) obj;
		return idProducto == other.idProducto;
	}
	
	
}
