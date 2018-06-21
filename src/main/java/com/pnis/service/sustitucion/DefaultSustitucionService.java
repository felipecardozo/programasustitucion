package com.pnis.service.sustitucion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pnis.builder.SustitucionBuilder;
import com.pnis.crud.SustitucionRepository;
import com.pnis.crud.TerrenoRepository;
import com.pnis.crud.TipoSustitucionRepository;
import com.pnis.crud.UsuarioRepository;
import com.pnis.domain.Sustitucion;
import com.pnis.domain.Terreno;
import com.pnis.domain.TipoSustitucion;
import com.pnis.domain.Usuario;
import com.pnis.service.dto.SustitucionRequestDTO;

@Service
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
	public Sustitucion createSustitucion(SustitucionRequestDTO sustitucion) {
		SustitucionBuilder builder = new SustitucionBuilder(terrenoRepository, usuarioRepository, tipoSustitucionRepository);
		builder.buildTerreno(sustitucion.getIdTerreno())
			   .builDelegado(sustitucion.getIdDelegado())
			   .buildTipoSustitucion(sustitucion.getIdTipoSustitucion())
			   .buildEstado(sustitucion.getEstado())
			   .buildFechas(sustitucion.getFechaInicio(), sustitucion.getFechaFin());
		
		return sustitucionRepository.save(builder.build());
	}

	@Override
	public Sustitucion updateSustitucion(final Integer idSustitucion, final SustitucionRequestDTO sustitucion) {
		Sustitucion updateSustitucion = new Sustitucion();
		Optional<Sustitucion> sustitucionTemp =  sustitucionRepository.findById(idSustitucion);
		if( sustitucionTemp.isPresent() ) {
			updateSustitucion = sustitucionTemp.get();
		}
		if( sustitucion.getEstado()!=null ) {
			updateSustitucion.setEstado(sustitucion.getEstado());
		}
		if( sustitucion.getFechaInicio()!=null ) {
			updateSustitucion.setFechaInicio(sustitucion.getFechaInicio());
		}
		if( sustitucion.getFechaFin()!=null ) {
			updateSustitucion.setFechaFin(sustitucion.getFechaFin());
		}
		if( sustitucion.getIdDelegado()!=null ) {
			Optional<Usuario> delegado = usuarioRepository.findById(sustitucion.getIdDelegado());
			if( delegado.isPresent() ) {
				updateSustitucion.setDeledado(delegado.get());
			}
		}
		if( sustitucion.getIdTerreno()!=null ) {
			Optional<Terreno> terreno = terrenoRepository.findById(sustitucion.getIdTerreno());
			if( terreno.isPresent() ) {
				updateSustitucion.setTerreno(terreno.get());
			}
		}
		if( sustitucion.getIdTipoSustitucion()!=null ) {
			Optional<TipoSustitucion> tipoSustitucion = tipoSustitucionRepository.findById(sustitucion.getIdTipoSustitucion());
			if( tipoSustitucion.isPresent() ) {
				updateSustitucion.setTipoSustitucion(tipoSustitucion.get());
			}
		}
		return sustitucionRepository.save(updateSustitucion);
	}

	@Override
	public Boolean deleteSustitucion(int id) {
		sustitucionRepository.deleteById(id);
		Optional<Sustitucion> found = sustitucionRepository.findById(id);
		return !found.isPresent();
	}
	
	@Override
	public Sustitucion getSustitucionById(Integer id) {
		if( id != null ) {
			Optional<Sustitucion> found = sustitucionRepository.findById(id);
			if( found.isPresent() ) {
				return found.get();
			}
		}
		return new Sustitucion();
	}
	
}
