package com.pnis.service.sustitucion;

import lombok.Getter;

public enum SustitucionEstado {
	
	FINALIZADO("Finalizado"), EN_PROGRESO("En progreso");
	
	@Getter
	private String estado;
	
	SustitucionEstado(String estado) {
		this.estado = estado;
	}

}
