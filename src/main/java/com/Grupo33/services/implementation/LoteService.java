package com.Grupo33.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Grupo33.entities.Lote;
import com.Grupo33.entities.Producto;
import com.Grupo33.entities.Stock;
import com.Grupo33.models.LoteModelo;
import com.Grupo33.repositories.ILoteRepository;
import com.Grupo33.repositories.IProductoRepository;
import com.Grupo33.repositories.IStockRepository;
import com.Grupo33.services.ILoteService;

@Service("loteService")
public class LoteService implements ILoteService {

	@Autowired
	@Qualifier("loteRepository")
	private ILoteRepository loteRepository;
	
	@Autowired
	@Qualifier("ProductoRepository")
	private IProductoRepository productoRepository;
	
	@Autowired
	@Qualifier("stockRepository")
	private IStockRepository stockRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	public List<LoteModelo> getAll() {
		List<LoteModelo> lista = new ArrayList<LoteModelo>();
		
		for(Lote lote: loteRepository.findAll()) {
			lista.add(modelMapper.map(lote, LoteModelo.class));
		}
		return lista;
	}

	@Override
	public LoteModelo insertOrUpdate(Lote lote) {
		//Calculo el precio del lote y lo guardo
		lote.setPrecio(lote.getProducto().getCosto()*lote.getCantidad());
		//Ingreso la cantidad nueva de stock
		Producto producto = lote.getProducto();
		Stock stock = stockRepository.findByProductoIdProducto(producto.getIdProducto());
		//verifico que el exista el stock y sino existe lo creo
		if(stock == null) {
			stock = new Stock(lote.getCantidad(),5,producto);
			
		}else {
			stock.setCantidad(stock.getCantidad() + lote.getCantidad());
		}
		stockRepository.save(stock);
		
		return modelMapper.map(loteRepository.save(lote), LoteModelo.class);
	}

	@Override
	public boolean remove(int id) {
		try {
			loteRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	
}
