package com.Grupo33.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Grupo33.entities.Pedido;
import com.Grupo33.models.PedidoModelo;
import com.Grupo33.repositories.IPedidoRepository;
import com.Grupo33.services.IPedidoService;

@Service("pedidoService")
public class PedidoService implements IPedidoService {

	@Autowired
	@Qualifier("pedidoRepository")
	private IPedidoRepository pedidoRepository;
	
	private ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<PedidoModelo> getAll() {
		List<PedidoModelo> lista = new ArrayList<>();
		for(Pedido pedido: pedidoRepository.findAll()) {
			lista.add(modelMapper.map(pedido,PedidoModelo.class));
		}
		return lista;
	}

	@Override
	public PedidoModelo insertOrUpdate(Pedido pedido) {
		return modelMapper.map(pedidoRepository.save(pedido), PedidoModelo.class);
	}

	@Override
	public boolean remove(int id) {
		try {
			pedidoRepository.deleteById(id);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

	@Override
	public Pedido getById(int id) {
		// TODO Auto-generated method stub
		return pedidoRepository.getById(id);
	}
	
	
	
}
