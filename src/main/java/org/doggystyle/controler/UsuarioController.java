package org.doggystyle.controler;

import java.util.List;
import java.util.Optional;

import org.doggystyle.model.Estado;
import org.doggystyle.model.Tipo;
import org.doggystyle.model.Usuario;
import org.doggystyle.service.EstadoService;
import org.doggystyle.service.TipoService;
import org.doggystyle.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/views/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioservice;
	
	@Autowired
	private TipoService tiposervice;
	
	@Autowired
	private EstadoService estadoservice;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Usuario>usuarios = usuarioservice.listar();		
		model.addAttribute("titulo", "Lista de Usuarios");
		model.addAttribute("usuarios", usuarios);		
		return "/views/usuarios/listar";
	}
	
	@GetMapping("/nuevo")
	public String agregar(Model model) {		
		Usuario usuario = new Usuario();
		List<Tipo> listTipo = tiposervice.listaTipo();
		List<Estado> listEstado = estadoservice.listaEstado();
		model.addAttribute("titulo","Nuevo Cliente");
		model.addAttribute("usuario", usuario);
		model.addAttribute("tipo", listTipo);
		model.addAttribute("estado", listEstado);
		return "/views/usuarios/form";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Validated Usuario u, Model model) {
		usuarioservice.guardar(u);
		return "redirect:/views/usuarios/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		
		List<Tipo> listTipo = tiposervice.listaTipo();
		List<Estado> listEstado = estadoservice.listaEstado();
		Optional<Usuario>usuario = usuarioservice.listarId(id);
		model.addAttribute("titulo","Editar Cliente");
		model.addAttribute("usuario", usuario);
		model.addAttribute("tipo", listTipo);
		model.addAttribute("estado", listEstado);
		return "/views/usuarios/form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(Model model, @PathVariable int id) {
		usuarioservice.eliminar(id);
		System.out.println("registro eliminado con exito");
		return "redirect:/views/usuarios/listar";
		
	}

}
