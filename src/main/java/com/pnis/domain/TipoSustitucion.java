package com.pnis.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name="tiposustitucion")
public class TipoSustitucion {
	
	@Id
	@Getter
	@Setter
	private Integer id;

	@Getter
	@Setter
	private String nombre;

	@Getter
	@Setter
	private String codigo;

}
