package org.doggystyle.service;

import java.util.List;
import java.util.Optional;

import org.doggystyle.model.Usuario;
import org.doggystyle.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> findAll() {
		return (List<Usuario>)usuarioRepository.findAll();
	}
	
	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Optional<Usuario> get(int id) {
		return usuarioRepository.findById(id);
	}

	@Override
	public int update(Usuario u) {
		int res=0;
		Usuario usuario = usuarioRepository.save(u);
		if(!usuario.equals(null)) {
			res = 1;
		}
		return res;
	}
	

	@Override
	public void delete(int id) {
		usuarioRepository.deleteById(id);
		
	}

	

	

}
