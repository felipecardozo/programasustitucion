package com.pnis.crud;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pnis.domain.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	
	public Usuario findByEmailAndPassword(String email, String password);
	
	public Usuario findByEmail(String email);
	
	@Query("SELECT usuario.email FROM Usuario usuario WHERE usuario.idTipoUsuario = ?1")
	public List<String> findAllEmailByTipoUsuario(Integer idTipoUsuario);

}
