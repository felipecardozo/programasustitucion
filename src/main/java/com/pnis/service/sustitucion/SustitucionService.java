package com.pnis.service.sustitucion;

import java.util.List;

import com.pnis.domain.Sustitucion;
import com.pnis.service.dto.SustitucionDTO;

public interface SustitucionService {
	
	public List<Sustitucion> getAllSustituciones();
	
	public Sustitucion createSustitucion(SustitucionDTO sustitucion);
	
	public Sustitucion updateSustitucion(SustitucionDTO sustitucion);
	
	public Boolean deleteSustitucion(int id);

}
