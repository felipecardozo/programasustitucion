package com.pnis.api;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pnis.crud.AcuerdoRepository;
import com.pnis.crud.SustitucionRepository;
import com.pnis.domain.Acuerdo;
import com.pnis.domain.Sustitucion;
import com.pnis.dto.AcuerdoDTO;

public class RestAcuerdo {
	
	@Inject
	private AcuerdoRepository acuerdoRepository;
	
	@Inject 
	private SustitucionRepository sustitucionRepository;
	
	@PutMapping("/acuerdo/{idAcuerdo}")
	public @ResponseBody Acuerdo actualizarAcuerdo(@PathVariable Integer idAcuerdo, @RequestBody AcuerdoDTO acuerdo) {
		Optional<Acuerdo> acuerdoOptional = acuerdoRepository.findById(idAcuerdo);
		if( acuerdoOptional.isPresent() ) {
			Acuerdo toUpdate = acuerdoOptional.get();
			if( acuerdo.getAprobado()!=null ) {
				toUpdate.setAprobado(acuerdo.getAprobado());
			}
			if( acuerdo.getFechaAcuerdo()!=null ) {
				toUpdate.setFechaAcuerdo(acuerdo.getFechaAcuerdo());
			}
			if( acuerdo.getArchivo() != null ) {
				toUpdate.setArchivo(acuerdo.getArchivo());
			}
			return acuerdoRepository.save(toUpdate);
		}
		return new Acuerdo();
	}
	
	@PostMapping("/acuerdo/{idSustitucion}")
	public @ResponseBody Acuerdo createAcuerdo(@PathVariable Integer idSustitucion, @RequestBody Acuerdo acuerdo) {
		Optional<Sustitucion> sustitucionOpt = sustitucionRepository.findById(idSustitucion);
		if( sustitucionOpt.isPresent() ) {
			Sustitucion sustitucion = sustitucionOpt.get();
			Acuerdo acuerdoCreated = acuerdoRepository.save(acuerdo);
			sustitucion.setAcuerdo(acuerdoCreated);
			sustitucion = sustitucionRepository.save(sustitucion);
			return acuerdoCreated;
		}
		return new Acuerdo();
	}

}
