package com.pnis.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Propietario {
	
	@Id
	@Getter
	@Setter
	private int id;

	@Getter
	@Setter
	private String nombre;

	@Getter
	@Setter
	private String numeroIdentificacion;

	@Getter
	@Setter
	private String tipoDocumento;

}
