package org.doggystyle.service;

import java.util.List;
import java.util.Optional;

import org.doggystyle.model.Producto;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoService {

	public List<Producto> findAll();
	public Producto save (Producto producto);
	public Optional<Producto>get(int id);
	public int update(Producto p);
	public void delete(int id);
	
	
}
