package org.doggystyle.controler;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.doggystyle.model.Categoria;
import org.doggystyle.model.Estado;
import org.doggystyle.model.Producto;
import org.doggystyle.model.Usuario;
import org.doggystyle.service.CategoriaService;
import org.doggystyle.service.EstadoService;
import org.doggystyle.service.ProductoService;
import org.doggystyle.service.UploadFileService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/productos")
public class ProductoController {
	
	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
	@Autowired
	private ProductoService productoservice;
	
	@Autowired
	private CategoriaService categoriaservice;
	
	@Autowired
	private EstadoService estadoservice;
	
	@Autowired
	private UploadFileService upload;
	
	@GetMapping("")
	public String list(Model model) {
		List<Producto>productos = productoservice.findAll();		
		model.addAttribute("titulo", "Lista de Productos");
		model.addAttribute("productos", productos);		
		return "productos/show";
	}
	
	@GetMapping("/create")
	public String create(Model model) {		
		Producto producto = new Producto();
		List<Categoria> listCategoria = categoriaservice.findAll();
		List<Estado> listEstado = estadoservice.listaEstado();
		model.addAttribute("titulo","Nuevo Producto");
		model.addAttribute("producto", producto);
		model.addAttribute("categoria", listCategoria);
		model.addAttribute("estado", listEstado);
		return "/productos/form";
	}
	
	@PostMapping("/save")
	public String save(@Validated Producto producto, Model model, @RequestParam("img") MultipartFile file) throws IOException{
		LOGGER.info("Este es el objeto producto {}",producto);
		
		Usuario u = new Usuario(1, "", "", "", "", "", "", null, null);
		producto.setUsuario(u);		
		
		//imagen
		if(producto.getId() == 0) {
			String nombreImagen = upload.saveImage(file);
			producto.setImagen(nombreImagen);
		}else {
			if(file.isEmpty()) {
				Producto p= new Producto();
				p = productoservice.get(producto.getId()).get();
				producto.setImagen(p.getImagen());
				
			}else {
				String nombreImagen = upload.saveImage(file);
				producto.setImagen(nombreImagen);
			}
		}
		
		productoservice.save(producto);
		return "redirect:/productos";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable int id, Model model) {		
		List<Categoria> listCategoria = categoriaservice.findAll();
		List<Estado> listEstado = estadoservice.listaEstado();
		Optional<Producto>producto = productoservice.get(id);
		model.addAttribute("titulo","Editar Producto");
		model.addAttribute("producto", producto);
		model.addAttribute("categoria", listCategoria);
		model.addAttribute("estado", listEstado);
		return "/productos/form";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		productoservice.delete(id);
		System.out.println("registro eliminado con exito");
		return "redirect:/productos/";	
	}
}