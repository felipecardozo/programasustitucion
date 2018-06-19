package com.pnis.service.acuerdo;

import java.io.IOException;

import com.pnis.dto.MensajeDTO;
import com.pnis.dto.RealizarAcuerdoDTO;

public interface AcuerdoService {
	
	public MensajeDTO realizar(RealizarAcuerdoDTO acuerdo) throws IOException;

}
