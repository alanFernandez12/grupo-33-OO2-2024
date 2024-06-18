package com.Grupo33.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.Grupo33.entities.Venta;

@Repository("VentaRepository")
public interface IVentaRepository extends JpaRepository<Venta,Integer> {
	
	
	
	public abstract Venta getById(int id);
	
	

}
