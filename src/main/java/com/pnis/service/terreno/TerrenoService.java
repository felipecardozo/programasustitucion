package com.pnis.service.terreno;

import java.util.List;

import com.pnis.domain.Terreno;

public interface TerrenoService {
	
	public List<Terreno> getTerrenos(String identificacion);
	
	public List<Terreno> getTerrenos();
	
	public Terreno createTerreno(Terreno terreno);
	
	public Terreno updateTerreno(Terreno terreno);
	
	public Boolean deleteTerreno(Integer id);

}
