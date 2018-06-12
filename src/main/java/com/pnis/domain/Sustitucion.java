package com.pnis.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Sustitucion {
	
	@Id
	@Getter
	@Setter
	private int id;

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
	private int idDelegado;

	@Getter
	@Setter
	private int idTerreno;

	@Getter
	@Setter
	private int tipoSustitucion;
	

}
