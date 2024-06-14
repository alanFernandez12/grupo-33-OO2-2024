package com.Grupo33.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Grupo33.entities.Producto;
import com.Grupo33.models.ProductoModelo;
import com.Grupo33.repositories.IProductoRepository;
import com.Grupo33.services.IProductoService;

@Service("productoService")
public class ProductoService implements IProductoService {
	
	@Autowired
	@Qualifier("ProductoRepository")
	private IProductoRepository productoRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<ProductoModelo> getAll() {
		List<ProductoModelo> lista = new ArrayList<>();
		
		for (Producto producto : productoRepository.findAll()) {
			lista.add(modelMapper.map(producto, ProductoModelo.class)); //convertimos el producto a producto modelo
		}
		return lista;
	}

	@Override
	public ProductoModelo insertOrUpdate(Producto producto) {
		Producto p = productoRepository.save(producto);
		
		return modelMapper.map(p, ProductoModelo.class);
	}

	@Override
	public boolean remove(int id) {
		try {
			productoRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}

	@Override
	public Producto getById(int id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id).orElse(null);
	}

	
}
