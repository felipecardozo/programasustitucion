package com.pnis.service.login;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pnis.crud.UsuarioRepository;
import com.pnis.domain.Usuario;
import com.pnis.dto.LoginDTO;

@Service
public class StandardLoginService implements LoginService {

	@Inject
	private UsuarioRepository usuarioRepository;
	
	@Override
	public Usuario login(LoginDTO login) {
		return usuarioRepository.findByEmailAndPassword(login.getEmail(), login.getPassword());
	}

}
