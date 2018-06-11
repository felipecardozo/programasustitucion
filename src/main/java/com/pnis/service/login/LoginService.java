package com.pnis.service.login;

import com.pnis.domain.Usuario;
import com.pnis.dto.LoginDTO;

public interface LoginService {

	public Usuario login(LoginDTO login);
	
}
