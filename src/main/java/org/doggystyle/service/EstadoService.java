package org.doggystyle.service;

import java.util.List;

import org.doggystyle.beans.Estado;
import org.doggystyle.interfaceService.IEstadoService;
import org.doggystyle.interfaces.EstadoInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService implements IEstadoService{
	
	@Autowired
	private EstadoInterfaces estadoInterfaces;

	@Override
	public List<Estado> listaEstado() {
		// TODO Auto-generated method stub
		return (List<Estado>)estadoInterfaces.findAll();
	}
	
	

}
