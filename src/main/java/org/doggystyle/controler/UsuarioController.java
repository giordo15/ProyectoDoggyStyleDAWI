package org.doggystyle.controler;

import java.util.List;
import java.util.Optional;


import org.doggystyle.model.Usuario;
import org.doggystyle.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
	@Autowired
	private UsuarioService usuarioservice;
	
	
	@GetMapping("")
	public String list(Model model) {
		List<Usuario>usuarios = usuarioservice.findAll();		
		model.addAttribute("titulo", "Lista de Usuarios");
		model.addAttribute("usuarios", usuarios);		
		return "/usuarios/show";
	}
	
	@GetMapping("/create")
	public String create(Model model) {		
		Usuario usuario = new Usuario();
		model.addAttribute("titulo","Nuevo Cliente");
		model.addAttribute("usuario", usuario);
		return "/usuarios/form";
	}
	
	@PostMapping("/save")
	public String save(@Validated Usuario u, Model model) {
		LOGGER.info("Este es el objeto usuario {}",u);
		usuarioservice.save(u);
		return "redirect:/usuarios";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model model) {	
		Optional<Usuario>usuario = usuarioservice.get(id);
		model.addAttribute("titulo","Editar Cliente");
		model.addAttribute("usuario", usuario);
		return "/usuarios/form";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		usuarioservice.delete(id);
		System.out.println("registro eliminado con exito");
		return "redirect:/usuarios";
	}

}
