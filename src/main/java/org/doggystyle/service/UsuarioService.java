package org.doggystyle.service;

import java.util.List;
import java.util.Optional;

import org.doggystyle.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioService {
	
	public List<Usuario>listar();
	public Optional<Usuario>listarId(int id);
	public int guardar(Usuario u);
	public void eliminar(int id);
}
