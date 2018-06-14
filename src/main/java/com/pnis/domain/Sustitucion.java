package com.pnis.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Sustitucion {
	
	@Id
	@Getter
	@Setter
	private int id;

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
	

}
