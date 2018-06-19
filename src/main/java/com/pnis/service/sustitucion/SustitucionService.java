package com.pnis.service.sustitucion;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.pnis.domain.Sustitucion;
import com.pnis.dto.MensajeDTO;
import com.pnis.dto.SustituirRequestDTO;
import com.pnis.service.dto.SustitucionRequestDTO;

public interface SustitucionService {
	
	public List<Sustitucion> getAllSustituciones();
	
	public Sustitucion createSustitucion(SustitucionRequestDTO sustitucion);
	
	public Sustitucion getSustitucionById(Integer id);
	
	public Sustitucion updateSustitucion(SustitucionRequestDTO sustitucion);
	
	public Boolean deleteSustitucion(int id);
	
	public MensajeDTO sustituir(SustituirRequestDTO request) throws IOException;

}
