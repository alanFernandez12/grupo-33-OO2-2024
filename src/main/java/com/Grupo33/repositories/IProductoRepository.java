package com.Grupo33.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Grupo33.entities.Producto;


@Repository("ProductoRepository")
public interface IProductoRepository extends JpaRepository<Producto,Integer> {

	public abstract Producto findByNombre(String nombre);
	
	public abstract Producto getById(int id);

}
