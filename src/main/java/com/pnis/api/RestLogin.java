package com.pnis.api;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pnis.domain.Usuario;
import com.pnis.dto.LoginDTO;
import com.pnis.service.login.LoginService;

@RestController
public class RestLogin {
	
	@Inject
	private LoginService loginService;
	
	@PostMapping("/login")
	public @ResponseBody Usuario login(@RequestBody LoginDTO login) {
		return loginService.login(login);
	}
	

}
