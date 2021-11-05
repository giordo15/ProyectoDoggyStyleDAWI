package org.doggystyle.service;

import java.util.List;

import org.doggystyle.beans.Tipo;
import org.doggystyle.interfaceService.ITipoService;
import org.doggystyle.interfaces.TipoInterfaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoService implements ITipoService{
	
	@Autowired
	private TipoInterfaces tipoInterfaces;

	@Override
	public List<Tipo> listaTipo() {
		
		return (List<Tipo>)tipoInterfaces.findAll();
	}
	
	

}
