package com.Grupo33.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Grupo33.entities.Lote;
import com.Grupo33.helpers.ViewRouteHelper;
import com.Grupo33.models.LoteModelo;
import com.Grupo33.services.ILoteService;
import com.Grupo33.services.IProductoService;


@Controller
@RequestMapping("/lote")
public class LoteController {

	private ModelMapper modelMapper=new ModelMapper();
	
	@Autowired
	@Qualifier("loteService")
	private ILoteService loteService;
	
	@Autowired
	@Qualifier("productoService")
	private IProductoService productoService;
	
	
	@GetMapping("/agregarLote")
	private String agregarLote(Model model) {
		model.addAttribute("lote", new LoteModelo());
		model.addAttribute("productos",productoService.getAll());
		return ViewRouteHelper.AgregarLote;
	}

	@PostMapping("/nuevoLote")
	public ModelAndView nuevoLote(@ModelAttribute("lote") LoteModelo loteModelo, BindingResult b) {
		ModelAndView mv=new ModelAndView();
		
		if(b.hasErrors()) {
			mv.setViewName(ViewRouteHelper.AgregarLote);
		}
		else {
			loteService.insertOrUpdate(modelMapper.map(loteModelo,Lote.class));
			
			mv.setViewName(ViewRouteHelper.ListaLote);
			mv.addObject("lotes",loteService.getAll());
		}
		
		return mv;
	}
	
	@GetMapping("/listaLote")
	public ModelAndView mostrarLote(@ModelAttribute("lote")LoteModelo loteModelo) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(ViewRouteHelper.ListaLote);
		mv.addObject("lotes",loteService.getAll());	
		return mv;
	}
	
}
