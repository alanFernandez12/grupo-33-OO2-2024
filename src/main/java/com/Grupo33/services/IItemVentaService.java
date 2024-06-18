package com.Grupo33.services;

import java.util.List;

import com.Grupo33.entities.ItemVenta;
import com.Grupo33.entities.Stock;
import com.Grupo33.entities.Venta;
import com.Grupo33.models.StockModelo;

public interface IItemVentaService {

	public List<ItemVenta> getAll();
	public ItemVenta insertOrUpdate(ItemVenta itemVenta);
	public boolean remove(int id);
	public ItemVenta getById(int id);
	public Venta getVentaByVentaId(int idVenta);
}
