package org.doggystyle.repository;

import org.doggystyle.model.Orden;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends CrudRepository<Orden, Integer>{

}
