package org.doggystyle.service;

import java.util.List;
import java.util.Optional;

import org.doggystyle.model.Categoria;
import org.doggystyle.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository data;

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