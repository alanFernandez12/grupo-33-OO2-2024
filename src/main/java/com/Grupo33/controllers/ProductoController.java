package com.Grupo33.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Grupo33.helpers.ViewRouteHelper;
import com.Grupo33.models.ProductoModelo;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@GetMapping("/agregar")
	private String agregarProducto(Model model) {
		model.addAttribute("producto", new ProductoModelo());
		return ViewRouteHelper.AgregarProducto;
	}

}
