package com.Grupo33.models;

import java.time.LocalDate;
import java.util.List;

import com.Grupo33.entities.ItemVenta;
import com.Grupo33.entities.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VentaModelo {
	

	private int idVenta;
	
	private List<ItemVenta> items;
	
	private User usuario;
	
	private LocalDate fecha;
	
	private double total;

	public VentaModelo() {
		
	}
	
}
	