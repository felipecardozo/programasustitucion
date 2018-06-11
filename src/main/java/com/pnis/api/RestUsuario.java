package com.pnis.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RestUsuario {
	
	@GetMapping("/usuario/{email}")
	public @ResponseBody String getUsuario(@PathVariable String email ) {
		
		return "SUCESS";
	}
	

}
