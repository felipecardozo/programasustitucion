package com.pnis.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Terreno {
	
	@Id
	@Getter
	@Setter
	private int id;

	@Getter
	@Setter
	private Double latitud;

	@Getter
	@Setter
	private Double longitud;

	@Getter
	@Setter
	private int tamanio;

	@Getter
	@Setter
	private String nombre;

	@OneToOne
	@JoinColumn(name="id_propietario")
	@Getter
	@Setter
	private Propietario propietario;

	@OneToOne
	@JoinColumn(name="id_municipio")
	@Getter
	@Setter
	private Municipio municipio;

}
