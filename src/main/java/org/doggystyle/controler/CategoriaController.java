package org.doggystyle.controler;

import java.util.List;
import java.util.Optional;


import org.doggystyle.model.Categoria;
import org.doggystyle.model.Estado;
import org.doggystyle.service.CategoriaService;
import org.doggystyle.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaservice;
	
	@Autowired
	private EstadoService estadoservice;
		
	@GetMapping("")
	public String list(Model model) {
		List<Categoria>categorias = categoriaservice.findAll();		
		model.addAttribute("titulo", "Lista de Categorias");
		model.addAttribute("categorias", categorias);		
		return "/categorias/show";
	}
	
	@GetMapping("/create")
	public String agregar(Model model) {		
		Categoria categoria = new Categoria();
		List<Estado> listEstado = estadoservice.listaEstado();
		model.addAttribute("titulo","Nueva Categoria");
		model.addAttribute("categoria", categoria);
		model.addAttribute("estado", listEstado);
		return "/categorias/form";
	}
	
	@PostMapping("/save")
	public String save(@Validated Categoria c, Model model) {
		categoriaservice.save(c);
		return "redirect:/categorias/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		List<Estado> listEstado = estadoservice.listaEstado();
		Optional<Categoria>categoria = categoriaservice.get(id);
		model.addAttribute("titulo","Editar Categoria");
		model.addAttribute("categoria", categoria);
		model.addAttribute("estado", listEstado);
		return "/categorias/form";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		categoriaservice.delete(id);
		System.out.println("registro eliminado con exito");
		return "redirect:/categorias/";	
	}
}