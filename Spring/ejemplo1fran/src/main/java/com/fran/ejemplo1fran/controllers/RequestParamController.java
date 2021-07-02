package com.fran.ejemplo1fran.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class RequestParamController {
	
	@GetMapping({"/index","/","","/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Index dentro de params");
		return "params/index";
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(name="texto",required=false,defaultValue="algún valor...") String texto, Model model) {		
		model.addAttribute("parametro", "El texto enviado es: " + texto);
		return "params/ver";
	}
	
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo,@RequestParam Integer numero, Model model) {
		model.addAttribute("parametro", "El saludo es: " + saludo + " y el número es: '" + numero + "'");
		return "params/ver";		
	}

}
