package com.pnis.service.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class SustitucionDTO {
	
	@Getter
	@Setter
	private Date fechaInicio;

	@Getter
	@Setter
	private Date fechaFin;

	@Getter
	@Setter
	private String estado;

	@Getter
	@Setter
	private int idTerreno;

	@Getter
	@Setter
	private int idDelegado;

	@Getter
	@Setter
	private int idTipoSustitucion;

}
