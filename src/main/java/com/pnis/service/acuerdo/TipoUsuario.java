package com.pnis.service.acuerdo;

public enum TipoUsuario {

	SUPER_DELEGADO(1);
	
	private Integer id;
	
	TipoUsuario(Integer id){
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}
	
}
