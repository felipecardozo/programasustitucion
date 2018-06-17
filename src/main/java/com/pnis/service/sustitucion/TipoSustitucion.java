package com.pnis.service.sustitucion;

public enum TipoSustitucion {
	
	VOLUNTARIA, OBLIGATORIA;
	
	public String getShortTitle() {
		return this.toString().toLowerCase();
	}
	
	public String found(String tipo) {
		if( tipo.equalsIgnoreCase(this.getShortTitle()) ) {
			return this.getShortTitle();
		}
		else {
			return null;
		}
	}

}
