package com.pnis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Municipio {
	
	@Id
	@Getter
	@Setter
	private int id;

	@Getter
	@Setter
	private String nombre;

	@Getter
	@Setter
	private double latitud;

	@Getter
	@Setter
	private double longitud;

	@Column(name="id_departamento")
	@Getter
	@Setter
	private int idDepartamento;

}
