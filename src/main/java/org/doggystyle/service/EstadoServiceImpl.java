package org.doggystyle.service;

import java.util.List;

import org.doggystyle.model.Estado;
import org.doggystyle.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoServiceImpl implements EstadoService{
	
	@Autowired
	private EstadoRepository estadoInterfaces;

	@Override
	public List<Estado> listaEstado() {
		// TODO Auto-generated method stub
		return (List<Estado>)estadoInterfaces.findAll();
	}
	
	

}
