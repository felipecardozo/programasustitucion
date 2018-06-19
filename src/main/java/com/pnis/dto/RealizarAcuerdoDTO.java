package com.pnis.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

public class RealizarAcuerdoDTO {
	
	@Getter
	@Setter
	private Integer idSustitucion; 

	@Getter
	@Setter
	private Integer idTipoSustitucion; 

	@Getter
	@Setter
	private Integer idDelegado;
	
	@Getter
	@Setter
	private String estado;
	
	@Getter
	@Setter
	private MultipartFile file;
	
	@Getter
	@Setter
	private String aprobado;

}
