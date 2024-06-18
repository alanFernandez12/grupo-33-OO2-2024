package com.Grupo33.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Grupo33.helpers.ViewRouteHelper;
import com.Grupo33.models.StockModelo;
import com.Grupo33.services.IStockService;

@Controller
@RequestMapping("/stock")
public class StockController {

	@Autowired
	@Qualifier("stockService")
	private IStockService stockService;
	
	@GetMapping("/listaStock")
	public ModelAndView mostrarStock(@ModelAttribute("stock")StockModelo stockModelo) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName(ViewRouteHelper.verStock);
		mv.addObject("stocks",stockService.getAll());	
		return mv;
	}
	
}
