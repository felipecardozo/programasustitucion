package com.pnis.service.sustitucion;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pnis.crud.SustitucionRepository;
import com.pnis.crud.TerrenoRepository;
import com.pnis.crud.TipoSustitucionRepository;
import com.pnis.crud.UsuarioRepository;
import com.pnis.domain.Sustitucion;
import com.pnis.domain.Terreno;
import com.pnis.domain.TipoSustitucion;
import com.pnis.domain.Usuario;
import com.pnis.dto.MensajeDTO;
import com.pnis.dto.SustituirRequestDTO;
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
	public Sustitucion updateSustitucion(SustitucionRequestDTO sustitucion) {
		Sustitucion updateSustitucion = new Sustitucion();
		if( sustitucion.getEstado()!=null ) {
			updateSustitucion.setEstado(sustitucion.getEstado());
		}
		if( sustitucion.getFechaInicio()!=null ) {
			updateSustitucion.setFechaInicio(sustitucion.getFechaInicio());
		}
		if( sustitucion.getFechaFin()!=null ) {
			updateSustitucion.setFechaFin(sustitucion.getFechaFin());
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

	private MensajeDTO sustituir(SustituirRequestDTO request) throws IOException {
		Optional<Sustitucion> found = sustitucionRepository.findById( request.getIdSustitucion());
		if( found.isPresent() ) {
			Sustitucion sustitucion = found.get();
			
			TipoSustitucion tipoSusObj = tipoSustitucionRepository.findById(request.getIdTipoSustitucion()).get();
			sustitucion.setTipoSustitucion(tipoSusObj);
			
			String archivo =  "C:\\AEM\\workspace\\programa-sustitucion\\uploads\\"+ sustitucion.getTipoSustitucion().getCodigo() + "-"+sustitucion.getId() +"-" + request.getFile().getOriginalFilename();
			File fileConverter = new File(archivo);
			fileConverter.createNewFile();
			FileOutputStream fileOutput = new FileOutputStream(fileConverter);
			fileOutput.write(request.getFile().getBytes());
			fileOutput.close();
			
//			sustitucion.setArchivo(archivo);
			sustitucion.setEstado(request.getEstado());
			
			Optional<Usuario> usuarioOptional = usuarioRepository.findById(request.getIdDelegado());
			if( usuarioOptional.isPresent() ) {
				sustitucion.setDeledado(usuarioOptional.get());
			}
			
			Sustitucion saved = sustitucionRepository.save(sustitucion);
			if( saved != null ) {
				return new MensajeDTO("La sustitucion ha sido realizada satisfactoriamente");
			}
		}
		return new MensajeDTO("La sustitucion no se ha completado");
		
	}
	
}
