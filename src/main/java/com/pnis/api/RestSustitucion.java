package com.pnis.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pnis.domain.Sustitucion;
import com.pnis.dto.MensajeDTO;
import com.pnis.dto.SustituirRequestDTO;
import com.pnis.service.dto.SustitucionRequestDTO;
import com.pnis.service.sustitucion.SustitucionService;

@RestController
public class RestSustitucion {

	@Inject
	private SustitucionService sustitucionService;
	
	@GetMapping(value="/sustituciones")
	public @ResponseBody List<Sustitucion> getAllSustituciones(){
		return sustitucionService.getAllSustituciones();
	}
	
	@GetMapping("/sustitucion/{id}")
	public @ResponseBody Sustitucion getSustitucionById(@PathVariable Integer id) {
		return sustitucionService.getSustitucionById(id);
	}
	
	@PostMapping("/sustitucion")
	public Sustitucion createSustitucion(@RequestBody SustitucionRequestDTO sustitucion) {
		return sustitucionService.createSustitucion(sustitucion);
	}
	
	@PutMapping("/sustitucion")
	public Sustitucion updateSustitucion(@RequestBody SustitucionRequestDTO sustitucion) {
		return sustitucionService.updateSustitucion(sustitucion);
	}
	
	@DeleteMapping("/sustitucion/{id}")
	public Boolean deleteSustitucion(@PathVariable Integer id) {
		return sustitucionService.deleteSustitucion(id);
	}
	
	/*@PostMapping(value="/sustituir/{idSustitucion}/{idTipo}/{idDelegado}/{estado}/{aprobado}", consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
	public MensajeDTO sustituir(@PathVariable Integer idSustitucion, @PathVariable Integer idTipo, @PathVariable Integer idDelegado, @PathVariable String estado, @PathVariable String aprobado, @RequestParam MultipartFile file) {
		SustituirRequestDTO request = new SustituirRequestDTO();
		request.setIdSustitucion(idSustitucion);
		request.setIdTipoSustitucion(idTipo);
		request.setIdDelegado(idDelegado);
		request.setFile(file);
		request.setEstado(estado);
		try {
			return sustitucionService.sustituir(request);
		} catch (IOException e) {
			return new MensajeDTO("Error haciendo la sustitucion " + idSustitucion + ": " + e.getMessage());
		}
	}*/

}
