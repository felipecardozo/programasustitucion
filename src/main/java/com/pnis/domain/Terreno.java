package com.pnis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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

	@Column(name="id_propietario")
	@Getter
	@Setter
	private int idPropietario;

	@Column(name="id_municipio")
	@Getter
	@Setter
	private int idMunicipio;

}
