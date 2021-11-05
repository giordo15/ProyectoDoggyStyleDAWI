package org.doggystyle.interfaceService;

import java.util.List;
import java.util.Optional;

import org.doggystyle.beans.Producto;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoService {
	
	public List<Producto>listar();
	public Optional<Producto>listarId(int id);
	public int guardar(Producto p);
	public void eliminar(int id);
}
