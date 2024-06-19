package com.Grupo33.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Grupo33.entities.ItemVenta;
import com.Grupo33.entities.Venta;
import com.Grupo33.models.ProductoModelo;
import com.Grupo33.models.StockModelo;
import com.Grupo33.repositories.IItemVentaRepository;
import com.Grupo33.services.IItemVentaService;

@Service("itemVentaService")
public class ItemVentaService implements IItemVentaService {
	
	@Autowired
	@Qualifier("ItemVentaRepository")
	private IItemVentaRepository itemVentaRepository;
	
	
	
	@Override
	public List<ItemVenta> getAll() {
		List<ItemVenta> lista = new ArrayList<>();
		// TODO Auto-generated method stub
		for (ItemVenta itemVenta : itemVentaRepository.findAll()) {
			lista.add(itemVenta);
		}
		return lista;
	}

	@Override
	public ItemVenta insertOrUpdate(ItemVenta itemVenta) {
		ItemVenta item = itemVentaRepository.save(itemVenta);
		// TODO Auto-generated method stub
		return item;
	}

	@Override
	public boolean remove(int id) {
		try {
			itemVentaRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
		// TODO Auto-generated method stub

	}

	@Override
	public ItemVenta getById(int id) {
		// TODO Auto-generated method stub
		return itemVentaRepository.getById(id);
	}

	@Override
	public Venta getVentaByVentaId(int idVenta) {
		
		return null;
	}

}
