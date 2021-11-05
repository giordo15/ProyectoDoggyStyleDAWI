package org.doggystyle.interfaceService;

import java.util.List;
import java.util.Optional;

import org.doggystyle.beans.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioService {
	
	public List<Usuario>listar();
	public Optional<Usuario>listarId(int id);
	public int guardar(Usuario u);
	public void eliminar(int id);
}
