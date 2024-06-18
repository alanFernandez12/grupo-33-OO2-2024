package com.Grupo33.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.Grupo33.entities.Stock;

@Repository("stockRepository")
public interface IStockRepository extends JpaRepository<Stock,Integer>{
	public abstract Stock getById(int id);
	public Stock findByProductoIdProducto(int idProducto);
}
