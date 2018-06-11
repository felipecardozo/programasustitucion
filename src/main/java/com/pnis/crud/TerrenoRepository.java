package com.pnis.crud;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pnis.domain.Terreno;

public interface TerrenoRepository extends CrudRepository<Terreno, Integer>{

	public List<Terreno> findAllByIdPropietario(int idPropietario);
	
	
}
