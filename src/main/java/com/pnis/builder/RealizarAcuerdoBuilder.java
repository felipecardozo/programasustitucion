package com.pnis.builder;

import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.pnis.builder.file.FileBridge;
import com.pnis.crud.AcuerdoRepository;
import com.pnis.crud.SustitucionRepository;
import com.pnis.crud.TipoSustitucionRepository;
import com.pnis.crud.UsuarioRepository;
import com.pnis.domain.Acuerdo;
import com.pnis.domain.Sustitucion;
import com.pnis.domain.TipoSustitucion;
import com.pnis.domain.Usuario;

public class RealizarAcuerdoBuilder {

	private SustitucionRepository sustitucionRepository;
	private TipoSustitucionRepository tipoSustitucionRepository;
	private UsuarioRepository usuarioRepository;
	private AcuerdoRepository acuerdoRepository;
	private Sustitucion sustitucion;
	private String archivo;
	private FileBridge fileBridge;
	
	public RealizarAcuerdoBuilder(AcuerdoRepository acuerdoRepository, TipoSustitucionRepository tipoSustitucionRepository, UsuarioRepository usuarioRepository, SustitucionRepository sustitucionRepository) {
		this.sustitucionRepository = sustitucionRepository;
		this.tipoSustitucionRepository = tipoSustitucionRepository;
		this.usuarioRepository = usuarioRepository;
		this.acuerdoRepository = acuerdoRepository;
		sustitucion = new Sustitucion();
	}
	
	public RealizarAcuerdoBuilder buildSustitucion(Integer idSustitucion) {
		if( idSustitucion != null ) {
			Optional<Sustitucion> found = sustitucionRepository.findById( idSustitucion );
			if( found.isPresent() ) {
				sustitucion = found.get();
			}
		}
		return this;
	}
	
	public RealizarAcuerdoBuilder buildFile(FileBridge fileBridge) {
		if( fileBridge!=null ) {
			this.fileBridge = fileBridge;
		}
		return this;
	}
	
	public RealizarAcuerdoBuilder buildArchivo(MultipartFile file) throws IOException {
		if( sustitucion != null && fileBridge != null ) {
			if( sustitucion.getTipoSustitucion()!=null && sustitucion.getTipoSustitucion().getCodigo()!=null ) {
				fileBridge.buildCodigo(sustitucion.getTipoSustitucion().getCodigo());
			}
			fileBridge.buildIdFile(sustitucion.getId());
			this.archivo = fileBridge.buildArchivo(file);
		}
		return this;
	}
	
	public RealizarAcuerdoBuilder buildTipoSustitucion(Integer idTipoSustitucion) {
		if( idTipoSustitucion!=null ) {
			Optional<TipoSustitucion> tipoSustitucion = tipoSustitucionRepository.findById(idTipoSustitucion);
			if( tipoSustitucion.isPresent() ) {
				sustitucion.setTipoSustitucion(tipoSustitucion.get());
			}			
		}
		return this;
	}
	
	public RealizarAcuerdoBuilder buildDelegado(Integer idDelegado) {
		if( idDelegado != null ) {
			Optional<Usuario> usuario = usuarioRepository.findById(idDelegado);
			if( usuario!=null ) {
				sustitucion.setDeledado(usuario.get());
			}
		}
		
		return this;
	}
	
	public RealizarAcuerdoBuilder buildEstado(final String estado) {
		if( estado != null ) {
			sustitucion.setEstado(estado);
		}
		return this;
	}
	
	public Sustitucion buildAcuerdo(final String aprobado) {
		if(archivo != null) {
			Acuerdo acuerdo = new Acuerdo();
			acuerdo.setAprobado(aprobado);
			acuerdo.setFechaAcuerdo( new Date(Calendar.getInstance().getTime().getTime()) );
			acuerdo.setArchivo(archivo);
			Acuerdo acuerdoCreado = acuerdoRepository.save(acuerdo);
			sustitucion.setAcuerdo(acuerdoCreado);
		}
		return sustitucionRepository.save(sustitucion);
	}
	
}
