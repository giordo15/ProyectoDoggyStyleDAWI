package org.doggystyle.service;

import java.util.List;
import java.util.Optional;

import org.doggystyle.model.Categoria;

public interface CategoriaService {
	
	List<Categoria> listar();
	public Optional<Categoria>listarId(int id);
	public int guardar(Categoria c);
	public void eliminar(int id);

}
