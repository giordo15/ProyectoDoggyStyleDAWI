package org.doggystyle.service;

import java.util.List;
import java.util.Optional;

import org.doggystyle.beans.Categoria;
import org.doggystyle.interfaceService.ICategoriaService;
import org.doggystyle.interfaces.CategoriaInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService implements ICategoriaService {

	@Autowired
	private CategoriaInterfaces data;

	@Override
	public List<Categoria> listar() {
		return (List<Categoria>) data.findAll();
	}

	@Override
	public Optional<Categoria> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int guardar(Categoria c) {
		int res = 0;
		Categoria categoria = data.save(c);
		if (!categoria.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void eliminar(int id) {
		data.deleteById(id);
	}
}