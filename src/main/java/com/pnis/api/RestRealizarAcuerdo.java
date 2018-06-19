package com.pnis.api;

import java.io.IOException;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pnis.dto.MensajeDTO;
import com.pnis.dto.RealizarAcuerdoDTO;
import com.pnis.service.acuerdo.AcuerdoService;

@RestController
public class RestRealizarAcuerdo {
	
	@Inject
	private AcuerdoService acuerdoService;
	
	@PostMapping(value="/sustituir/{idSustitucion}", consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
	public MensajeDTO sustituir(@PathVariable Integer idSustitucion, @RequestParam(value="idtiposustitucion", required=true) Integer idTipoSustitucion,
			@RequestParam(value="iddelegado", required=true) Integer idDelegado, @RequestParam(value="estado", required=true) String estado, 
			@RequestParam(value="aprobado", required=true) String aprobado, @RequestParam MultipartFile file ) {
		RealizarAcuerdoDTO request = new RealizarAcuerdoDTO();
		request.setIdSustitucion(idSustitucion);
		request.setIdTipoSustitucion(idTipoSustitucion);
		request.setIdDelegado(idDelegado);
		request.setEstado(estado);
		request.setAprobado(aprobado);
		request.setFile(file);
		
		try {
			return acuerdoService.realizar(request);
		} catch (IOException e) {
			return new MensajeDTO("Error haciendo la sustitucion " + idSustitucion + ": " + e.getMessage());
		}
	}

}
