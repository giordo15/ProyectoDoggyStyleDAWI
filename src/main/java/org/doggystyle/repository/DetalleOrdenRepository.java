package org.doggystyle.repository;

import org.doggystyle.model.DetalleOrden;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleOrdenRepository extends CrudRepository<DetalleOrden, Integer> {

}
