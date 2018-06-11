package com.pnis.crud;

import org.springframework.data.repository.CrudRepository;

import com.pnis.domain.Propietario;

public interface PropietarioRepository extends CrudRepository<Propietario, Integer> {

	public Propietario findByNumeroIdentificacion(String numeroIdentificacion);
	
}
