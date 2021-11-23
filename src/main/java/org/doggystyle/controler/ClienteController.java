package org.doggystyle.controler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.doggystyle.model.DetalleOrden;
import org.doggystyle.model.Orden;
import org.doggystyle.model.Producto;
import org.doggystyle.model.Usuario;
import org.doggystyle.service.DetalleOrdenService;
import org.doggystyle.service.OrdenService;
import org.doggystyle.service.ProductoService;
import org.doggystyle.service.UsuarioService;
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

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private OrdenService ordenService;

	@Autowired
	private DetalleOrdenService detalleOrdenService;

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
		double sumaTotal = 0;

		Optional<Producto> optionalProducto = productoService.get(id);
		log.info("Producto añadido: {}", optionalProducto.get());
		log.info("Cantidad: {}", cantidad);

		producto = optionalProducto.get();

		detalleOrden.setCantidad(cantidad);
		detalleOrden.setPrecio(producto.getPrecio());
		detalleOrden.setNombre(producto.getNombre());
		detalleOrden.setTotal(producto.getPrecio() * cantidad);
		detalleOrden.setProducto(producto);

		// validar que el producto no se añada 2 veces

		Integer idProducto = producto.getId();
		boolean ingresado = detalles.stream().anyMatch(p -> p.getProducto().getId() == idProducto);

		if (!ingresado) {
			detalles.add(detalleOrden);
		}
		sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

		orden.setTotal(sumaTotal);

		model.addAttribute("cart", detalles);
		model.addAttribute("orden", orden);

		return "clientes/carrito";
	}

	@GetMapping("/delete/cart/{id}")
	public String deleteProductoCart(@PathVariable Integer id, Model model) {

		List<DetalleOrden> ordenesNueva = new ArrayList<DetalleOrden>();

		for (DetalleOrden detalleOrden : detalles) {
			if (detalleOrden.getProducto().getId() != id) {
				ordenesNueva.add(detalleOrden);
			}
		}

		// nueva lista con los productos
		detalles = ordenesNueva;

		double sumaTotal = 0;
		sumaTotal = detalles.stream().mapToDouble(dt -> dt.getTotal()).sum();

		orden.setTotal(sumaTotal);
		model.addAttribute("cart", detalles);
		model.addAttribute("orden", orden);

		return "clientes/carrito";
	}

	@GetMapping("/getCart")
	public String getCart(Model model) {
		model.addAttribute("cart", detalles);
		model.addAttribute("orden", orden);
		return "/clientes/carrito";
	}

	@GetMapping("/order")
	public String order(Model model) {

		Usuario usuario = usuarioService.findById(1).get();

		model.addAttribute("cart", detalles);
		model.addAttribute("orden", orden);
		model.addAttribute("usuario", usuario);

		return "clientes/resumenorden";
	}

	// guardar la orden
	@GetMapping("/saveOrder")
	public String saveOrder(Model model) {

		Date fechaCreacion = new Date();
		orden.setFechaCreacion(fechaCreacion);
		orden.setNumero(ordenService.generarNumeroOrden());

		// usuario

		Usuario usuario = usuarioService.findById(1).get();

		orden.setUsuario(usuario);
		ordenService.save(orden);

		for (DetalleOrden dt : detalles) {
			dt.setOrden(orden);
			detalleOrdenService.save(dt);
		}

		// limpieza de lista y orden
		orden = new Orden();
		detalles.clear();

		return "redirect:/home";
	}
	
	@PostMapping("/search")
	public String searchProduct(@RequestParam String nombre, Model model) {
		log.info("Nombre del Producto = {}", nombre);
		List<Producto> productos = productoService.findAll().stream().filter( p -> p.getNombre().contains(nombre)).collect(Collectors.toList());
		model.addAttribute("productos", productos);
		return "clientes/home";
		
	}
	
	
	
	
}