package com.fran.ejemplo1fran.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class PathVariablesController {
	
	@GetMapping({"/index","/","","/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Index dentro de path variables");
		return "variables/index";
	}
	
	@GetMapping("/string/{texto}")
	public String param(@PathVariable String texto, Model model) {
		model.addAttribute("parametro", texto);
		return "variables/ver";		
	}
	
	@GetMapping("/string/{texto}/{numero}")
	public String param(@PathVariable String texto, @PathVariable Integer numero, Model model) {
		model.addAttribute("parametro",  "El saludo es: " + texto + " y el número es: '" + numero + "'");
		return "variables/ver";		
	}

}
