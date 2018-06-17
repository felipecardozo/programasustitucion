package com.pnis.crud;

import org.springframework.data.repository.CrudRepository;

import com.pnis.domain.TipoSustitucion;

public interface TipoSustitucionRepository extends CrudRepository<TipoSustitucion, Integer> {
	
	public TipoSustitucion findByNombre(String nombre);

}
