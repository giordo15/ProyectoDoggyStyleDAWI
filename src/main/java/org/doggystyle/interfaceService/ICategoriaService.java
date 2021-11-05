package org.doggystyle.interfaceService;

import java.util.List;
import java.util.Optional;

import org.doggystyle.beans.Categoria;

public interface ICategoriaService {
	
	List<Categoria> listar();
	public Optional<Categoria>listarId(int id);
	public int guardar(Categoria c);
	public void eliminar(int id);

}
