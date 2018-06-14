package com.pnis.api;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pnis.domain.Sustitucion;
import com.pnis.service.dto.SustitucionDTO;
import com.pnis.service.sustitucion.SustitucionService;

@RestController
public class RestSustitucion {

	@Inject
	private SustitucionService sustitucionService;
	
	@GetMapping(value="/sustituciones")
	public @ResponseBody List<Sustitucion> getAllSustituciones(){
		return sustitucionService.getAllSustituciones();
	}
	
	@PostMapping("/sustitucion")
	public Sustitucion createSustitucion(@RequestBody SustitucionDTO sustitucion) {
		return sustitucionService.createSustitucion(sustitucion);
	}
	
	@PutMapping("/sustitucion")
	public Sustitucion updateSustitucion(@RequestBody SustitucionDTO sustitucion) {
		return sustitucionService.updateSustitucion(sustitucion);
	}

}
