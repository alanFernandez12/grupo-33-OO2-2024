package com.Grupo33.services;

import java.util.List;

import com.Grupo33.entities.Venta;
import com.Grupo33.models.VentaModelo;



public interface IVentaService {


	public List<VentaModelo> getAll();
	public VentaModelo insertOrUpdate(Venta venta);
	public boolean remove(int id);
	public Venta getById(int id);
}
