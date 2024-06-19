package com.Grupo33.controllers;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.Grupo33.entities.Producto;
import com.Grupo33.entities.Stock;
import com.Grupo33.entities.Venta;
import com.Grupo33.helpers.ViewRouteHelper;
import com.Grupo33.models.ProductoModelo;
import com.Grupo33.models.StockModelo;
import com.Grupo33.services.IItemVentaService;
import com.Grupo33.services.ILoteService;
import com.Grupo33.services.IPedidoService;
import com.Grupo33.services.IProductoService;
import com.Grupo33.services.IStockService;
import com.Grupo33.services.IVentaService;
import com.Grupo33.entities.ItemVenta;


@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	private ModelMapper modelMapper=new ModelMapper();
	@Autowired
	@Qualifier("pedidoService")
	private IPedidoService pedidoService;
	
	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	@Autowired
	@Qualifier("stockService")
	private IStockService stockService;
	
	@Autowired
	@Qualifier("ventaService")
	private IVentaService ventaService;

	@Autowired
	@Qualifier("itemVentaService")
	private IItemVentaService itemVentaService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
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
	@GetMapping("/listaProductosCliente")
	public ModelAndView mostrarProductosCliente(@ModelAttribute("producto")ProductoModelo productoM) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(ViewRouteHelper.ListaProducto);
		mv.addObject("productos",productoService.getAll());	
		return mv;
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
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
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/eliminarProduto/{idProducto}")
	public ModelAndView eliminarProducto(@PathVariable int idProducto) {
		
		Stock s = stockService.getStocksByProductoId(idProducto);
		
		if(s != null) {
		  stockService.remove(s.getIdStock());
		}
		productoService.remove(idProducto);
		ModelAndView mv=new ModelAndView();
		mv.setViewName(ViewRouteHelper.ListaProducto);
		mv.addObject("productos",productoService.getAll());

		return mv;
		
	}
	 @GetMapping("/detalle/{idProducto}")
	    public ModelAndView mostrarDetalleProducto(@PathVariable("idProducto") int idProducto) {
	        ModelAndView mv = new ModelAndView();
	        Stock s = new Stock();
			 s = stockService.getStocksByProductoId(idProducto);
			 
			 if(s == null || s.getCantidad() ==0) {
				 mv.setViewName(ViewRouteHelper.ListaProducto);
				 mv.addObject("mensajeError", "No hay stock Disponible");
				mv.addObject("productos",productoService.getAll());	
				return mv;
			 }
	        mv.setViewName(ViewRouteHelper.verStockProducto); // El nombre del archivo HTML que acabamos de crear
	        mv.addObject("stock",stockService.getStocksByProductoId(idProducto)); 
	        return mv;
	    }
	 
	 @GetMapping("/itemProducto/{idProducto}")
	 public ModelAndView generarItemVenta(@PathVariable("idProducto") int idProducto, Model model) {
		 ModelAndView mv= new ModelAndView();
		 Stock s = new Stock();
		 s = stockService.getStocksByProductoId(idProducto);
		 
		 if(s == null || s.getCantidad() ==0) {
			 mv.setViewName(ViewRouteHelper.ListaProducto);
			 mv.addObject("mensajeError", "No hay stock Disponible");
			mv.addObject("productos",productoService.getAll());	
			return mv;
		 }
		 
		
		 mv.setViewName(ViewRouteHelper.ItemProducto);
		 mv.addObject("stock",stockService.getStocksByProductoId(idProducto));
		 model.addAttribute("stock", new StockModelo());
		 return mv;
	 }
	
	 @PostMapping("/itemProducto/{idStock}/venta")
	 public ModelAndView generarVenta(@RequestParam("cantidad") int cantidad, @PathVariable("idStock") int idStock,@ModelAttribute("stock") StockModelo stockModelo,Model model) {
		 ModelAndView mv=new ModelAndView();
		 int existe = 0;
		
		Stock stock = stockService.getById(idStock);
		Producto producto = stock.getProducto();
		
		
		
		if(cantidad > stock.getCantidad()) {
			mv.setViewName(ViewRouteHelper.ItemProducto);
			mv.addObject("mensajeError", "No se puede comprar más cantidad de los disponibles en stock.");
			mv.addObject("stock",stockService.getStocksByProductoId(producto.getIdProducto()));
			return mv;
		}
		
		//verifica si ya hay un producto en el carrito para subirle la cantidad
		for (ItemVenta item : itemVentaService.getAll()) {
			
			if (item.getProducto().equals(producto)) {
				
//				item.setCantidad(item.getCantidad() + stockModelo.getCantidad());
				item.setCantidad(item.getCantidad() + cantidad);
				double subprecio = item.getCantidad()* stock.getProducto().getPrecio();
				
				item.setSubPrecio(subprecio);
				itemVentaService.insertOrUpdate(item);
				
				 existe = 1;
			}
			
		}
		
		// si no existe el producto crea un item Nuevo
		if (existe != 1) {
			
		double subprecio = cantidad * stock.getProducto().getPrecio();
		 ItemVenta itemVenta= new ItemVenta(producto,cantidad,subprecio,LocalDate.now());		 
		 itemVentaService.insertOrUpdate(itemVenta);
		
	
		}
		 
//		 int cantidad = stock.getCantidad();
		stock.setCantidad(stock.getCantidad()- cantidad);
		 stockService.insertOrUpdate(stock);

			
			mv.setViewName(ViewRouteHelper.ListaProducto);
			mv.addObject("productos",productoService.getAll());

		 return mv;
	 }
}
