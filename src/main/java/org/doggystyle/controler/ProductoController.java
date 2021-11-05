package org.doggystyle.controler;

import java.util.List;
import java.util.Optional;

import org.doggystyle.beans.Categoria;
import org.doggystyle.beans.Estado;
import org.doggystyle.beans.Producto;
import org.doggystyle.interfaceService.ICategoriaService;
import org.doggystyle.interfaceService.IEstadoService;
import org.doggystyle.interfaceService.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/views/productos")
public class ProductoController {
	
	@Autowired
	private IProductoService productoservice;
	
	@Autowired
	private ICategoriaService categoriaservice;
	
	@Autowired
	private IEstadoService estadoservice;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Producto>productos = productoservice.listar();		
		model.addAttribute("titulo", "Lista de Productos");
		model.addAttribute("productos", productos);		
		return "/views/productos/listar";
	}
	
	@GetMapping("/nuevo")
	public String agregar(Model model) {		
		Producto producto = new Producto();
		List<Categoria> listCategoria = categoriaservice.listar();
		List<Estado> listEstado = estadoservice.listaEstado();
		model.addAttribute("titulo","Nuevo Producto");
		model.addAttribute("producto", producto);
		model.addAttribute("categoria", listCategoria);
		model.addAttribute("estado", listEstado);
		return "/views/productos/form";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Validated Producto p, Model model) {
		productoservice.guardar(p);
		return "redirect:/views/productos/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		
		List<Categoria> listCategoria = categoriaservice.listar();
		List<Estado> listEstado = estadoservice.listaEstado();
		Optional<Producto>producto = productoservice.listarId(id);
		model.addAttribute("titulo","Editar Producto");
		model.addAttribute("producto", producto);
		model.addAttribute("categoria", listCategoria);
		model.addAttribute("estado", listEstado);
		return "/views/productos/form";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(Model model, @PathVariable int id) {
		productoservice.eliminar(id);
		System.out.println("registro eliminado con exito");
		return "redirect:/views/productos/listar";	
	}
}