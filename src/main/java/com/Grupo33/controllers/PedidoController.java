package com.Grupo33.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Grupo33.entities.Pedido;
import com.Grupo33.entities.Producto;
import com.Grupo33.helpers.ViewRouteHelper;
import com.Grupo33.models.LoteModelo;
import com.Grupo33.models.PedidoModelo;
import com.Grupo33.repositories.IPedidoRepository;
import com.Grupo33.services.IPedidoService;
import com.Grupo33.services.IProductoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

	private ModelMapper modelMapper = new ModelMapper();
	
	
	@Autowired
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@GetMapping("/agregarPedido")
	private String agregarPedido(Model model) {
		model.addAttribute("pedido", new PedidoModelo());
		model.addAttribute("productos",productoService.getAll());
		return ViewRouteHelper.AgregarPedido;
	}	
	
	@PostMapping("/nuevoPedido")
	public ModelAndView nuevoPedido(@ModelAttribute("pedido") PedidoModelo pedidoModelo, BindingResult b) {
		ModelAndView mv = new ModelAndView();
		
		if(b.hasErrors()) {
			mv.setViewName(ViewRouteHelper.AgregarPedido);
		}
		else {
			Pedido p = modelMapper.map(pedidoModelo,Pedido.class);
			pedidoService.insertOrUpdate(p);

			mv.setViewName(ViewRouteHelper.PedidosRealizados);
			mv.addObject("pedidos",pedidoService.getAll());
		}
		
		return mv;
	}
	
	@GetMapping("/pedidosRealizados")
	public ModelAndView mostrarPedido(@ModelAttribute("pedido")PedidoModelo pedidoModelo) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(ViewRouteHelper.PedidosRealizados);
		mv.addObject("pedidos",pedidoService.getAll());	
		return mv;
	}
	
}
