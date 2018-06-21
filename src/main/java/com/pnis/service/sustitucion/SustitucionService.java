package com.pnis.service.sustitucion;

import java.util.List;

import com.pnis.domain.Sustitucion;
import com.pnis.service.dto.SustitucionRequestDTO;

public interface SustitucionService {
	
	public List<Sustitucion> getAllSustituciones();
	
	public Sustitucion createSustitucion(SustitucionRequestDTO sustitucion);
	
	public Sustitucion getSustitucionById(Integer id);
	
	public Sustitucion updateSustitucion(final Integer idSustitucion, final SustitucionRequestDTO sustitucion);
	
	public Boolean deleteSustitucion(int id);
	
}
