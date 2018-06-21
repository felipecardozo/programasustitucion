package com.pnis.service.acuerdo;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pnis.builder.RealizarAcuerdoBuilder;
import com.pnis.builder.file.WindowsFileBridge;
import com.pnis.crud.AcuerdoRepository;
import com.pnis.crud.SustitucionRepository;
import com.pnis.crud.TipoSustitucionRepository;
import com.pnis.crud.UsuarioRepository;
import com.pnis.domain.Sustitucion;
import com.pnis.dto.MensajeDTO;
import com.pnis.dto.RealizarAcuerdoDTO;
import com.pnis.observer.DelegadoObserver;
import com.pnis.observer.NotificarDelegados;
import com.pnis.observer.Observer;
import com.pnis.observer.Subject;

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
		RealizarAcuerdoBuilder builder = new RealizarAcuerdoBuilder(acuerdoRepository, tipoSustitucionRepository, usuarioRepository, sustitucionRepository);
		builder.buildSustitucion(request.getIdSustitucion())
			   .buildFile(new WindowsFileBridge())
			   .buildArchivo(request.getFile())
			   .buildTipoSustitucion(request.getIdTipoSustitucion())
			   .buildDelegado(request.getIdDelegado())
			   .buildEstado(request.getEstado());
		Sustitucion sustitucion = builder.buildAcuerdo(request.getAprobado());
		notify(sustitucion);
		if( sustitucion != null ) {
			return new MensajeDTO("La sustitucion ha sido realizada satisfactoriamente");
		}
		
		return new MensajeDTO("La sustitucion no se ha completado");
	}
	
	private void notify(Sustitucion sustitucion) {
		if( sustitucion.getEstado().equalsIgnoreCase("Finalizado") ) {
			List<String> emails = usuarioRepository.findAllEmailByTipoUsuario(TipoUsuario.SUPER_DELEGADO.getId());
			Subject subject = new NotificarDelegados(emails, "la sustitucion con id " + sustitucion.getId() + " se ha finalizado !");
			Observer observer = new DelegadoObserver(subject);
			subject.registerObserver(observer);
		}
	}

}
