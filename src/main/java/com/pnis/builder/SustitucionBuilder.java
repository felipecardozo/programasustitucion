package com.pnis.builder;

import java.util.Date;
import java.util.Optional;

import com.pnis.crud.TerrenoRepository;
import com.pnis.crud.TipoSustitucionRepository;
import com.pnis.crud.UsuarioRepository;
import com.pnis.domain.Sustitucion;
import com.pnis.domain.Terreno;
import com.pnis.domain.TipoSustitucion;
import com.pnis.domain.Usuario;

public class SustitucionBuilder {
	
	private TerrenoRepository terrenoRepository; 
	private UsuarioRepository usuarioRepository; 
	private TipoSustitucionRepository tipoSustitucionRepository;
	private Sustitucion newSustitucion;
	
	public SustitucionBuilder(TerrenoRepository terrenoRepository, UsuarioRepository usuarioRepository, TipoSustitucionRepository tipoSustitucionRepository) {
		this.terrenoRepository = terrenoRepository;
		this.usuarioRepository = usuarioRepository;
		this.tipoSustitucionRepository = tipoSustitucionRepository;
		newSustitucion = new Sustitucion();
	}

	public SustitucionBuilder buildTerreno(Integer idTerreno) {
		if( idTerreno != null ) {
			Optional<Terreno> terreno = terrenoRepository.findById(idTerreno);
			if( terreno.isPresent() ) {
				newSustitucion.setTerreno(terreno.get());
			}
		}
		return this;
	}

	public SustitucionBuilder builDelegado(Integer idDelegado) {
		if( idDelegado != null ) {
			Optional<Usuario> usuario = usuarioRepository.findById(idDelegado);
			if( usuario.isPresent() ) {
				newSustitucion.setDeledado(usuario.get());
			}
		}
		return this;
	}

	public SustitucionBuilder buildTipoSustitucion(Integer idTipoSustitucion) {
		if( idTipoSustitucion != null ) {
			Optional<TipoSustitucion> tipo = tipoSustitucionRepository.findById(idTipoSustitucion);
			if( tipo.isPresent() ) {
				newSustitucion.setTipoSustitucion(tipo.get());
			}
		}
		return this;
	}

	public SustitucionBuilder buildEstado(String estado) {
		if( estado!=null ) {
			newSustitucion.setEstado(estado);
		}
		return this;
	}

	public SustitucionBuilder buildFechas(Date fechaInicio, Date fechaFin) {
		if( fechaInicio!=null ) {
			newSustitucion.setFechaInicio(fechaInicio);
		}
		if( fechaFin!=null ) {
			newSustitucion.setFechaFin(fechaFin);
		}
		return this;
	}

	public Sustitucion build() {
		return newSustitucion;
	}
	

}
