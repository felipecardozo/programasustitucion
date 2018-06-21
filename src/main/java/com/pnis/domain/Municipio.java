package com.pnis.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Municipio {
	
	@Id
	@Getter
	@Setter
	private Integer id;

	@Getter
	@Setter
	private String nombre;

	@Getter
	@Setter
	private double latitud;

	@Getter
	@Setter
	private double longitud;

	@OneToOne
	@JoinColumn(name="id_departamento")
	@Getter
	@Setter
	private Departamento departamento;

}
