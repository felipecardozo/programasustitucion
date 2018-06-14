package com.pnis.service.sustitucion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import com.pnis.crud.SustitucionRepository;
import com.pnis.crud.TerrenoRepository;
import com.pnis.crud.TipoSustitucionRepository;
import com.pnis.crud.UsuarioRepository;
import com.pnis.domain.Sustitucion;
import com.pnis.domain.Terreno;
import com.pnis.domain.TipoSustitucion;
import com.pnis.domain.Usuario;
import com.pnis.service.dto.SustitucionDTO;

public class DefaultSustitucionService implements SustitucionService{
	
	@Inject
	private SustitucionRepository sustitucionRepository;
	
	@Inject
	private TerrenoRepository terrenoRepository;
	
	@Inject
	private UsuarioRepository usuarioRepository;
	
	@Inject
	private TipoSustitucionRepository tipoSustitucionRepository;
	
	@Override
	public List<Sustitucion> getAllSustituciones() {
		Iterable<Sustitucion> lista = sustitucionRepository.findAll();
		List<Sustitucion> sustituciones = new ArrayList<>();
		lista.forEach(sustituciones::add);
		return sustituciones;
	}

	@Override
	public Sustitucion createSustitucion(SustitucionDTO sustitucion) {
		Sustitucion newSustitucion = new Sustitucion();
		if( sustitucion.getIdTerreno()!=0 ) {
			Optional<Terreno> terreno = terrenoRepository.findById(sustitucion.getIdTerreno());
			if( terreno.isPresent() ) {
				newSustitucion.setTerreno(terreno.get());
			}
		}
		if( sustitucion.getIdDelegado()!=0 ) {
			Optional<Usuario> usuario = usuarioRepository.findById(sustitucion.getIdDelegado());
			if( usuario.isPresent() ) {
				newSustitucion.setDeledado(usuario.get());
			}
		}
		if( sustitucion.getIdTipoSustitucion()!=0 ) {
			Optional<TipoSustitucion> tipo = tipoSustitucionRepository.findById(sustitucion.getIdTipoSustitucion());
			if( tipo.isPresent() ) {
				newSustitucion.setTipoSustitucion(tipo.get());
			}
		}
		if( sustitucion.getEstado()!=null ) {
			newSustitucion.setEstado(sustitucion.getEstado());
		}
		if( sustitucion.getFechaInicio()!=null ) {
			newSustitucion.setFechaInicio(sustitucion.getFechaInicio());
		}
		if( sustitucion.getFechaFin()!=null ) {
			newSustitucion.setFechaFin(sustitucion.getFechaFin());
		}
		return sustitucionRepository.save(newSustitucion);
	}

	@Override
	public Sustitucion updateSustitucion(SustitucionDTO sustitucion) {
		return null;
	}

	@Override
	public Boolean deleteSustitucion(int id) {
		return null;
	}
	

}
