package org.doggystyle.service;

import java.util.List;

import org.doggystyle.model.Orden;


public interface OrdenService {

	List<Orden> findAll();
	
	Orden save(Orden orden);
	
	String generarNumeroOrden();
}
