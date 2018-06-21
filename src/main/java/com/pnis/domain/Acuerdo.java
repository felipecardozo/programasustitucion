package com.pnis.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Acuerdo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	@Setter
	private Integer id;
	
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
