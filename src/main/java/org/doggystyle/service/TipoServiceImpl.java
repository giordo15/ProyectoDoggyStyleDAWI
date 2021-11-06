package org.doggystyle.service;

import java.util.List;

import org.doggystyle.model.Tipo;
import org.doggystyle.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoServiceImpl implements TipoService{
	
	@Autowired
	private TipoRepository tipoInterfaces;

	@Override
	public List<Tipo> listaTipo() {
		
		return (List<Tipo>)tipoInterfaces.findAll();
	}
	
	

}
