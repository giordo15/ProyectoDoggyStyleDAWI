package org.doggystyle.controler;

import java.util.List;
import java.util.Optional;

import org.doggystyle.beans.Categoria;
import org.doggystyle.beans.Estado;
import org.doggystyle.interfaceService.ICategoriaService;
import org.doggystyle.interfaceService.IEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/views/categorias")
public class CategoriaController {
	
	@Autowired
	private ICategoriaService categoriaservice;
	
	@Autowired
	private IEstadoService estadoservice;
		
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Categoria>categorias = categoriaservice.listar();		
		model.addAttribute("titulo", "Lista de Categorias");
		model.addAttribute("categorias", categorias);		
		return "/views/categorias/listar";
	}
	
	@GetMapping("/nuevo")
	public String agregar(Model model) {		
		Categoria categoria = new Categoria();
		List<Estado> listEstado = estadoservice.listaEstado();
		model.addAttribute("titulo","Nueva Categoria");
		model.addAttribute("categoria", categoria);
		model.addAttribute("estado", listEstado);
		return "/views/categorias/form";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Validated Categoria c, Model model) {
		categoriaservice.guardar(c);
		return "redirect:/views/categorias/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		List<Estado> listEstado = estadoservice.listaEstado();
		Optional<Categoria>categoria = categoriaservice.listarId(id);
		model.addAttribute("titulo","Editar Categoria");
		model.addAttribute("categoria", categoria);
		model.addAttribute("estado", listEstado);
		return "/views/categorias/form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(Model model, @PathVariable int id) {
		categoriaservice.eliminar(id);
		System.out.println("registro eliminado con exito");
		return "redirect:/views/categorias/listar";	
	}
}