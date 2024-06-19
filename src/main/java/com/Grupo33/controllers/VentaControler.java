package com.Grupo33.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Grupo33.entities.ItemVenta;
import com.Grupo33.helpers.ViewRouteHelper;
import com.Grupo33.models.ItemVentaModelo;
import com.Grupo33.services.IProductoService;
import com.Grupo33.services.IVentaService;
import com.Grupo33.services.implementation.ItemVentaService;

@Controller
@RequestMapping("/carrito")
public class VentaControler {
	
	private ModelMapper modelMapper=new ModelMapper();
	
	
	@Autowired
	@Qualifier("itemVentaService")
	private ItemVentaService itemVentaService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@GetMapping("/verCarrito")
	public ModelAndView mostrarCarrito(@ModelAttribute("itemVenta")ItemVentaModelo itemVentaModelo) {
		ModelAndView mv=new ModelAndView();
		
		mv.setViewName(ViewRouteHelper.verCarrito);
		mv.addObject("itemVenta",itemVentaService.getAll());
		return mv;
	}
	
	@PostMapping("/verCarrito/compra")
	public ModelAndView compraRealizada() {
		ModelAndView mv=new ModelAndView();
		
		for (ItemVenta item	: itemVentaService.getAll()) {
			itemVentaService.remove(item.getIdItemVenta());
		}
		mv.setViewName(ViewRouteHelper.ListaProducto);
		mv.addObject("productos", productoService.getAll());
		return mv;
	}
	
	

}
