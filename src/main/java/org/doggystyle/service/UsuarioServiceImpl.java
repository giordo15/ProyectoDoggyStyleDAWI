package org.doggystyle.service;

import java.util.List;
import java.util.Optional;

import org.doggystyle.model.Usuario;
import org.doggystyle.repository.UsuarioInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	
	@Autowired
	private UsuarioInterfaces data;

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return (List<Usuario>)data.findAll();
	}

	@Override
	public Optional<Usuario> listarId(int id) {
		
		return data.findById(id);
	}

	@Override
	public int guardar(Usuario u) {
		int res=0;
		Usuario usuario = data.save(u);
		if(!usuario.equals(null)) {
			res = 1;
		}
		return res;
	}
	

	@Override
	public void eliminar(int id) {
		data.deleteById(id);
		
	}

	

}
