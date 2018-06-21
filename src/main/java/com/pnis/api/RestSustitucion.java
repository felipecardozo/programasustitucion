package com.pnis.api;

import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pnis.domain.Sustitucion;
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
	
	@PutMapping("/sustitucion/{idSustitucion}")
	public Sustitucion updateSustitucion(@PathVariable Integer idSustitucion, @RequestBody SustitucionRequestDTO sustitucion) {
		return sustitucionService.updateSustitucion(idSustitucion, sustitucion);
	}
	
	@DeleteMapping("/sustitucion/{id}")
	public Boolean deleteSustitucion(@PathVariable Integer id) {
		return sustitucionService.deleteSustitucion(id);
	}
	
}
