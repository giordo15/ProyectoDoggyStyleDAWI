package org.doggystyle.service;

import java.util.List;
import java.util.Optional;


import org.doggystyle.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioService {
	
	public List<Usuario>findAll();
	public Usuario save (Usuario usuario);	
	public Optional<Usuario>get(int id);
	public int update(Usuario u);
	public void delete(int id);
	
	Optional<Usuario> findById(Integer id);
}
