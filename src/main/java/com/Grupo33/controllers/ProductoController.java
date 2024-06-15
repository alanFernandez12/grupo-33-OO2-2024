package com.Grupo33.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Grupo33.entities.Producto;
import com.Grupo33.helpers.ViewRouteHelper;
import com.Grupo33.models.ProductoModelo;
import com.Grupo33.services.IProductoService;


@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	private ModelMapper modelMapper=new ModelMapper();
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	@GetMapping("/agregar")
	private String agregarProducto(Model model) {
		model.addAttribute("producto", new ProductoModelo());
		return ViewRouteHelper.AgregarProducto;
	}
	
	@PostMapping("/nuevoProducto")
	public ModelAndView nuevoProducto(@ModelAttribute("producto") ProductoModelo ProductoModelo, BindingResult b) {
		ModelAndView mv=new ModelAndView();
		
		if(b.hasErrors()) {
			mv.setViewName(ViewRouteHelper.AgregarProducto);
		}
		else {
			Producto p = modelMapper.map(ProductoModelo,Producto.class);
			productoService.insertOrUpdate(p);
			
			mv.setViewName(ViewRouteHelper.ListaProducto);
			mv.addObject("productos",productoService.getAll());
		}
		
		return mv;
	}
	
	@GetMapping("/listaProductos")
	public ModelAndView mostrarProductos(@ModelAttribute("producto")ProductoModelo productoM) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(ViewRouteHelper.ListaProducto);
		mv.addObject("productos",productoService.getAll());	
		return mv;
	}
	
	@GetMapping("/editarProducto{idProducto}")
	public String editarProducto(@PathVariable int idProducto,Model model) {
		Producto p = productoService.getById(idProducto);
		model.addAttribute("producto",modelMapper.map(p, ProductoModelo.class));
		
		return ViewRouteHelper.ModificarProducto;
	}
	
	@PostMapping("/editarProducto{idProducto}/guardar")
	public ModelAndView ModificarProducto(@PathVariable int idProducto, @ModelAttribute("producto") ProductoModelo productoM) {
		
		productoService.insertOrUpdate(modelMapper.map(productoM, Producto.class));
		ModelAndView mv = new ModelAndView();
		mv.setViewName(ViewRouteHelper.ListaProducto);
		mv.addObject("productos",productoService.getAll());
		return mv;
	}
	
	@GetMapping("/eliminarProduto{idPruducto}")
	public String eliminarProducto(@PathVariable("idProducto") int idProducto) {
		
		productoService.remove(idProducto);
//		ModelAndView mv=new ModelAndView();
//		mv.setViewName(ViewRouteHelper.ListaProducto);
//		mv.addObject("productos",productoService.getAll());
		return "redirect:/producto/listaProductos";
	}
}
