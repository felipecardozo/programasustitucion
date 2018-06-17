package com.pnis.crud;

import org.springframework.data.repository.CrudRepository;

import com.pnis.domain.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	
	public Usuario findByEmailAndPassword(String email, String password);
	
	public Usuario findByEmail(String email);

}
