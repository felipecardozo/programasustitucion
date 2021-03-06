package com.pnis.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Sustitucion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	@Setter
	private Integer id;

	@Column(name="fecha_inicio")
	@Getter
	@Setter
	private Date fechaInicio;

	@Column(name="fecha_fin")
	@Getter
	@Setter
	private Date fechaFin;

	@Getter
	@Setter
	private String estado;

	@OneToOne
	@JoinColumn(name="id_delegado")
	@Getter
	@Setter
	private Usuario deledado;

	@OneToOne
	@JoinColumn(name="id_terreno")
	@Getter
	@Setter
	private Terreno terreno;

	@OneToOne
	@JoinColumn(name="id_tiposustitucion")
	@Getter
	@Setter
	private TipoSustitucion tipoSustitucion;
	
	@OneToOne
	@JoinColumn(name = "id_acuerdo")
	@Getter
	@Setter
	private Acuerdo acuerdo;
	

}
