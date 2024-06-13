package com.Grupo33.services;
import java.util.List;

import com.Grupo33.entities.Producto;
import com.Grupo33.models.ProductoModelo;
public interface IProductoService {

	public List<ProductoModelo> getAll();
	public ProductoModelo insertOrUpdate(Producto producto);
	public boolean remove(int id);
	public Producto getById(int id);
}
