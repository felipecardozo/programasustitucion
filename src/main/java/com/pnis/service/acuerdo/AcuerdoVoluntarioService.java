package com.pnis.service.acuerdo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pnis.crud.AcuerdoRepository;
import com.pnis.crud.SustitucionRepository;
import com.pnis.crud.TipoSustitucionRepository;
import com.pnis.crud.UsuarioRepository;
import com.pnis.domain.Acuerdo;
import com.pnis.domain.Sustitucion;
import com.pnis.domain.TipoSustitucion;
import com.pnis.domain.Usuario;
import com.pnis.dto.MensajeDTO;
import com.pnis.dto.RealizarAcuerdoDTO;

@Service
public class AcuerdoVoluntarioService implements AcuerdoService {

	@Inject
	private SustitucionRepository sustitucionRepository;
	
	@Inject
	private TipoSustitucionRepository tipoSustitucionRepository;
	
	@Inject
	private UsuarioRepository usuarioRepository;
	
	@Inject
	private AcuerdoRepository acuerdoRepository;
	
	@Override
	public MensajeDTO realizar(RealizarAcuerdoDTO request) throws IOException {
		Optional<Sustitucion> found = sustitucionRepository.findById( request.getIdSustitucion() );
		if( found.isPresent() ) {
			Sustitucion sustitucion = found.get();
			
			String archivo =  "C:\\AEM\\workspace\\programa-sustitucion\\uploads\\"+ sustitucion.getTipoSustitucion().getCodigo() + "-"+sustitucion.getId() +"-" + request.getFile().getOriginalFilename();
			File fileConverter = new File(archivo);
			fileConverter.createNewFile();
			FileOutputStream fileOutput = new FileOutputStream(fileConverter);
			fileOutput.write(request.getFile().getBytes());
			fileOutput.close();
			
			Acuerdo acuerdo = new Acuerdo();
			acuerdo.setAprobado(request.getAprobado());
			acuerdo.setFechaAcuerdo( new Date(Calendar.getInstance().getTime().getTime()) );
			acuerdo.setArchivo(archivo);
			Acuerdo acuerdoCreado = acuerdoRepository.save(acuerdo);
			
			sustitucion.setAcuerdo(acuerdoCreado);
			TipoSustitucion tipoSustitucion = tipoSustitucionRepository.findById(request.getIdTipoSustitucion()).get();
			sustitucion.setTipoSustitucion(tipoSustitucion);
			
			Usuario usuario = usuarioRepository.findById(request.getIdDelegado()).get();
			sustitucion.setDeledado(usuario);
			
			sustitucion.setEstado(request.getEstado());
			
			Sustitucion updated = sustitucionRepository.save(sustitucion);
			if( updated != null ) {
				return new MensajeDTO("La sustitucion ha sido realizada satisfactoriamente");
			}
			
		}
		
		return new MensajeDTO("La sustitucion no se ha completado");
	}

}
