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
	private CategoriaRepository categoriaRepository;

	@Override
	public List<Categoria> findAll() {
		return (List<Categoria>)categoriaRepository.findAll();
	}

	@Override
	public Categoria save(Categoria categoria) {
		return categoriaRepository.save(categoria);
	}

	@Override
	public Optional<Categoria> get(int id) {
		return categoriaRepository.findById(id);
	}

	@Override
	public int update(Categoria c) {
		int res = 0;
		Categoria categoria = categoriaRepository.save(c);
		if (!categoria.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		categoriaRepository.deleteById(id);		
	}
}