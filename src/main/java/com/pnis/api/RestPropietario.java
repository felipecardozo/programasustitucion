package com.pnis.api;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pnis.crud.PropietarioRepository;
import com.pnis.domain.Propietario;

@RestController
@CrossOrigin(origins = { "http://localhost:8080", "http://pnis.ddns.net:8080" })
public class RestPropietario {
	
	@Inject
	private PropietarioRepository propietarioRepository;
	
	@GetMapping(value="/propietario/all")
	public @ResponseBody List<Propietario> getAllPropietarios() {
		List<Propietario> propietarios = new ArrayList<>();
		propietarioRepository.findAll().forEach(propietarios::add);
		return propietarios;
	}
	
	@GetMapping(value="/propietario/{identificacion}")
	public @ResponseBody Propietario getPropietario(@PathVariable String identificacion) {
		return propietarioRepository.findByNumeroIdentificacion(identificacion);
	}
	
	@PostMapping(value="/propietario")
	public @ResponseBody Propietario createPropietario(@RequestBody Propietario propietario) {
		Propietario exist = propietarioRepository.findByNumeroIdentificacion(propietario.getNumeroIdentificacion());
		if( exist == null ) {
			return propietarioRepository.save(propietario);
		}
		return null;
	}
	
	@PutMapping(value="/propietario")
	public @ResponseBody Propietario updatePropietario(@RequestBody Propietario propietario) {
		Propietario exist = propietarioRepository.findByNumeroIdentificacion(propietario.getNumeroIdentificacion());
		if( exist != null ) {
			if( propietario.getNombre()!=null ) {
				exist.setNombre(propietario.getNombre());
			}
			if( propietario.getTipoDocumento()!=null ) {
				exist.setTipoDocumento(propietario.getTipoDocumento());
			}
			return propietarioRepository.save(exist);
		}
		return null;
	}
	
	@DeleteMapping(value="/propietario/{identificacion}")
	public @ResponseBody Boolean deletePropietario(@PathVariable String identificacion) {
		Propietario exist = propietarioRepository.findByNumeroIdentificacion(identificacion);
		if( exist != null ) {
			propietarioRepository.delete(exist);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

}
