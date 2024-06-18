package com.Grupo33.services;

import java.util.List;

import com.Grupo33.entities.Lote;
import com.Grupo33.models.LoteModelo;

public interface ILoteService {

	public List<LoteModelo> getAll();
	
	public LoteModelo insertOrUpdate(Lote lote);
	
	public boolean remove(int id);
}
