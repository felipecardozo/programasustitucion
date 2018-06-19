package com.pnis.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pnis.crud.MunicipioRepository;
import com.pnis.crud.PropietarioRepository;
import com.pnis.crud.TerrenoRepository;
import com.pnis.crud.UsuarioRepository;
import com.pnis.domain.Municipio;
import com.pnis.domain.Propietario;
import com.pnis.domain.Terreno;
import com.pnis.domain.Usuario;

@RestController
public class RestTerreno {
	
	@Inject
	private TerrenoRepository terrenoRepository;
	
	@Inject
	private PropietarioRepository propietarioRepository;
	
	@Inject 
	private MunicipioRepository municipioRepository;
	
	@GetMapping(value="/terrenos/{identificacion}")
	public @ResponseBody List<Terreno> getTerrenos(@PathVariable String identificacion) {
		Propietario propietario = propietarioRepository.findByNumeroIdentificacion(identificacion);
		if( propietario != null ) {
			return terrenoRepository.findAllByPropietario(propietario);
		}
		return new ArrayList<>();
	}
	
	@GetMapping("/terreno/{id}")
	public @ResponseBody Terreno getTerrenoById(@PathVariable Integer id) {
		return terrenoRepository.findById(id).get();
	}
	
	@GetMapping(value="/terrenos")
	public @ResponseBody List<Terreno> getTerrenos() {
		List<Terreno> terrenos = new ArrayList<>();
		terrenoRepository.findAll().forEach(terrenos::add);
		return terrenos;
	}
	
	@PostMapping(value="/terreno")
	public @ResponseBody Terreno createTerreno(@RequestBody Terreno terreno) {
		return terrenoRepository.save(terreno);
	}
	
	@PutMapping(value="/terreno")
	public @ResponseBody Terreno updateTerreno(@RequestBody Terreno terreno) {
		Optional<Propietario> propietario = propietarioRepository.findById(terreno.getPropietario().getId());
		if( propietario.isPresent() ) {
			Optional<Terreno> exist = terrenoRepository.findById(terreno.getId());
			if( exist.isPresent() ) {
				Terreno found = exist.get();
				if( terreno.getNombre()!=null ) {
					found.setNombre(terreno.getNombre());
				}
				if( terreno.getLatitud()!=null ) {
					found.setLatitud(terreno.getLatitud());
				}
				if( terreno.getLongitud()!=null ) {
					found.setLongitud(terreno.getLongitud());
				}
				if( terreno.getTamanio()!=0 ) {
					found.setTamanio(terreno.getTamanio());
				}
				if( terreno.getMunicipio()!=null ) {
					Municipio municipio = municipioRepository.findById(terreno.getMunicipio().getId()).get();
					found.setMunicipio(municipio);
				}
				if( terreno.getPropietario()!=null ) {
					found.setPropietario(propietario.get());
				}
				return terrenoRepository.save(found);
			}
		}
		return null;
	}
	
	@DeleteMapping(value="/terreno/{idTerreno}")
	public @ResponseBody Boolean deleteTerreno(@PathVariable Integer idTerreno) {
		Optional<Terreno> exist = terrenoRepository.findById(idTerreno);
		if( exist.isPresent() ) {
			terrenoRepository.deleteById(idTerreno);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

}
