package com.fran.ejemplo1fran.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fran.ejemplo1fran.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	final String TITULO = "Página de prueba";
	
	@GetMapping({"/index","/","","/home"})
	public String index(Model model) {
		model.addAttribute("titulo", TITULO);
		return "index";
	}
	
	@RequestMapping(value = "/perfil")
	public String perfil(Model model) {
		// En la vida real el usuario que vamos a crear lo cogeríamos de Hibernate
		Usuario usuario = new Usuario();
		usuario.setNombre("Fran");
		usuario.setApellido("García");
		usuario.setEmail("a@a.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Perfíl del usuario ".concat(usuario.getNombre()));		
		return "perfil";
	}
	
	@RequestMapping(value = "/listar")
	public String listar(Model model) {
		// En la vida real el usuario que vamos a crear lo cogeríamos de Hibernate
		/*List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("Fran","García","fran@email.com"));
		usuarios.add(new Usuario("Fernando","Ruiz","fernando@email.com"));
		usuarios.add(new Usuario("Arturo","Bernal","arturo@email.com"));
		model.addAttribute("usuarios", usuarios);*/
		model.addAttribute("titulo", "Listar usuarios");		
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("Fran","García","fran@email.com"));
		usuarios.add(new Usuario("Fernando","Ruiz","fernando@email.com"));
		usuarios.add(new Usuario("Arturo","Bernal","arturo@email.com"));
		return usuarios;
	}
	

}
