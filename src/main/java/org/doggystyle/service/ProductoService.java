package org.doggystyle.service;

import java.util.List;
import java.util.Optional;

import org.doggystyle.beans.Producto;
import org.doggystyle.interfaceService.IProductoService;
import org.doggystyle.interfaces.ProductoInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {
	
	@Autowired
	private ProductoInterfaces data;

	@Override
	public List<Producto> listar() {
		return (List<Producto>)data.findAll();
	}

	@Override
	public Optional<Producto> listarId(int id) {		
		return data.findById(id);
	}

	@Override
	public int guardar(Producto p) {
		int res=0;
		Producto producto = data.save(p);
		if(!producto.equals(null)) {
			res = 1;
		}
		return res;
	}
	
	@Override
	public void eliminar(int id) {
		data.deleteById(id);
		
	}
}