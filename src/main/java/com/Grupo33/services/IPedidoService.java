package com.Grupo33.services;

import java.util.List;

import com.Grupo33.entities.Pedido;
import com.Grupo33.models.PedidoModelo;



public interface IPedidoService {

	public List<PedidoModelo> getAll();
	public PedidoModelo insertOrUpdate(Pedido pedido);
	public boolean remove(int id);
	public Pedido getById(int id);
}
