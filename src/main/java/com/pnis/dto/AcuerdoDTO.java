package com.pnis.dto;


import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

public class AcuerdoDTO {
	
	@Getter
	@Setter
	private Date fechaAcuerdo;

	@Getter
	@Setter
	private String aprobado;


	@Getter
	@Setter
	private String archivo;

}
