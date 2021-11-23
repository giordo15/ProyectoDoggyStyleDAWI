package org.doggystyle.service;

import org.doggystyle.model.DetalleOrden;
import org.doggystyle.repository.DetalleOrdenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleOrdenServiceImpl implements DetalleOrdenService{

	@Autowired
	private DetalleOrdenRepository detalleOrdenRepsitory;
	
	@Override
	public DetalleOrden save(DetalleOrden detalleOrden) {
		return detalleOrdenRepsitory.save(detalleOrden);
	}

}
