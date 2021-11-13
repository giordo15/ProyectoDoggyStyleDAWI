package org.doggystyle.controler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.doggystyle.model.DetalleOrden;
import org.doggystyle.model.Orden;
import org.doggystyle.model.Producto;
import org.doggystyle.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ClienteController {
	
	
	private final Logger log = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private ProductoService productoService;
	
	List<DetalleOrden> detalles = new ArrayList<DetalleOrden>();
	
	Orden orden = new Orden();
	
	@GetMapping("/home")
	public String home(Model model) {
		
		List<Producto> productos = productoService.findAll();
		model.addAttribute("productos", productos);
		return "clientes/home";
	}
	@GetMapping("productohome/{id}")
	public String productoshome(@PathVariable Integer id, Model model) {
		log.info("ID producto enviado como parametro {}", id);
		Producto producto = new Producto();
		Optional<Producto> productoOptional = productoService.get(id);
		producto = productoOptional.get();
		
		model.addAttribute("producto", producto);
		return "clientes/productohome";
	}
	
	@PostMapping("/cart")
	public String addCart(@RequestParam Integer id, @RequestParam Integer cantidad, Model model) {
		DetalleOrden detalleOrden = new DetalleOrden();
		Producto producto = new Producto();
		double sumaTotal =0;
		
		Optional<Producto> optionalProducto = productoService.get(id);
		log.info("Producto añadido: {}", optionalProducto.get());
		log.info("Cantidad: {}", cantidad);
		
		producto = optionalProducto.get();
		
		
		detalleOrden.setCantidad(cantidad);
		detalleOrden.setPrecio(producto.getPrecio());
		detalleOrden.setNombre(producto.getNombre());
		detalleOrden.setTotal(producto.getPrecio()* cantidad);
		detalleOrden.setProducto(producto);
		
		detalles.add(detalleOrden);
		
		sumaTotal = detalles.stream().mapToDouble(dt->dt.getTotal()).sum();
		
		orden.setTotal(sumaTotal);
		
		model.addAttribute("cart", detalles);
		model.addAttribute("orden", orden);
				
		return "clientes/carrito";
	}
}