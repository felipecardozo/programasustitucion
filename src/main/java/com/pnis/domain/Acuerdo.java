package com.pnis.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Acuerdo {
	
	@Id
	@Getter
	@Setter
	private int id;
	
	@Getter
	@Setter
	private String archivo;
	
	@Column(name="fecha_acuerdo")
	@Getter
	@Setter
	private Date fechaAcuerdo;
	
	@Getter
	@Setter
	private String aprobado;

}
