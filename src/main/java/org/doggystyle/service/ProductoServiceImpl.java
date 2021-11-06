package org.doggystyle.service;

import java.util.List;
import java.util.Optional;

import org.doggystyle.model.Producto;
import org.doggystyle.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Override
	public List<Producto> findAll() {
		return (List<Producto>)productoRepository.findAll();
	}

	@Override
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public Optional<Producto> get(int id) {
		return productoRepository.findById(id);
	}

	@Override
	public int update(Producto p) {
		int res=0;
		Producto producto = productoRepository.save(p);
		if(!producto.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		productoRepository.deleteById(id);
		
	}

}
