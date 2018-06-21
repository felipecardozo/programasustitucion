package com.pnis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Departamento {

	@Id
	@Getter
	@Setter
	private Integer id;
	
	
	@Getter
	@Setter
	private String nombre;
	
	@Column(name = "id_pais")
	@Getter
	@Setter
	private int idPais;
	
	@Getter
	@Setter
	private double latitud;
	
	@Getter
	@Setter
	private double longitud;
	
}
