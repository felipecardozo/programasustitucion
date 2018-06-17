package com.pnis.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

public class SustituirRequestDTO {
	
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
	private MultipartFile file;

}
