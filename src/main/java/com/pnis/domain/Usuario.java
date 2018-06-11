package com.pnis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Usuario {
	
	@Id
	@Getter
	@Setter
	private int id;
	
	@Getter
	@Setter
	private String nombre;
	
	@Getter
	@Setter
	private String numeroIdentificacion;
	
	@Getter
	@Setter
	private String email;
	
	@Getter
	@Setter
	private String password;
	
	@Getter
	@Setter
	@Column(name="id_tipousuario")
	private int idTipoUsuario;

}
