package org.doggystyle.service;

import java.util.List;
import java.util.Optional;

import org.doggystyle.model.Categoria;

public interface CategoriaService {
	
	List<Categoria> findAll();
	public Categoria save(Categoria categoria);
	public Optional<Categoria>get(int id);
	public int update(Categoria u);
	public void delete(int id);

}
