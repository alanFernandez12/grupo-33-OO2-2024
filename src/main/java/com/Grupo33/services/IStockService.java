package com.Grupo33.services;

import java.util.List;



import com.Grupo33.entities.Stock;

import com.Grupo33.models.StockModelo;


public interface IStockService {
	
	public List<StockModelo> getAll();
	public StockModelo insertOrUpdate(Stock stock);
	public boolean remove(int id);
	public Stock getById(int id);
	public Stock getStocksByProductoId(int idProducto);
}
