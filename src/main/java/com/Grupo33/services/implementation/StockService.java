package com.Grupo33.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.Grupo33.entities.Stock;

import com.Grupo33.models.StockModelo;
import com.Grupo33.repositories.IStockRepository;
import com.Grupo33.services.IStockService;

@Service("stockService")
public class StockService implements IStockService{

	@Autowired
	@Qualifier("stockRepository")
	private IStockRepository stockRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public List<StockModelo> getAll() {
		List<StockModelo> lista = new ArrayList<>();
		for (Stock stock : stockRepository.findAll()) {
			lista.add(modelMapper.map(stock, StockModelo.class));
			
		}
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public StockModelo insertOrUpdate(Stock stock) {
		Stock s = stockRepository.save(stock);
		// TODO Auto-generated method stub
		
		return modelMapper.map(s, StockModelo.class);
	}

	@Override
	public boolean remove(int id) {
		// TODO Auto-generated method stub
		try {
			stockRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Stock getById(int id) {
		// TODO Auto-generated method stub
		return stockRepository.findById(id).orElse(null);
	}

	@Override
	public Stock getStocksByProductoId(int idProducto) {
		// TODO Auto-generated method stub
		return stockRepository.findByProductoIdProducto(idProducto);
	}
	
	
}
