package com.Grupo33.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Grupo33.entities.Venta;
import com.Grupo33.models.ProductoModelo;
import com.Grupo33.models.VentaModelo;
import com.Grupo33.repositories.IVentaRepository;
import com.Grupo33.services.IVentaService;

@Service("ventaService")
public class VentaService implements IVentaService {
	
	@Autowired
	@Qualifier("VentaRepository")
	private IVentaRepository ventaRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<VentaModelo> getAll() {
		List<VentaModelo> lista = new ArrayList<>();
		
		for (Venta venta : ventaRepository.findAll()) {
			lista.add(modelMapper.map(venta, VentaModelo.class));
		}
		// TODO Auto-generated method stub
		return lista;
	}

	@Override
	public VentaModelo insertOrUpdate(Venta venta) {
		Venta v = ventaRepository.save(venta);
		
		return modelMapper.map(v, VentaModelo.class);
		
	}

	@Override
	public boolean remove(int id) {
		try {
			ventaRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Venta getById(int id) {
		
		return ventaRepository.findById(id).orElse(null);
	}

}
