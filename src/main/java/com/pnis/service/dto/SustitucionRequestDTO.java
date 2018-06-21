package com.pnis.service.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

public class SustitucionRequestDTO {
	
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
	private Integer idTerreno;

	@Getter
	@Setter
	private Integer idDelegado;

	@Getter
	@Setter
	private Integer idTipoSustitucion;

}
