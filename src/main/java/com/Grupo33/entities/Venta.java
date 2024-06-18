package com.Grupo33.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Venta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVenta; 
	
	@OneToOne
	@JoinColumn(name ="id_item_venta")
	private ItemVenta items;
	
	@OneToOne
	@JoinColumn(name = "user_id")
	private User usuario;
	
	private LocalDate fecha;
	
	private double total;

	public Venta() {
		
	}
	

	
	
}
