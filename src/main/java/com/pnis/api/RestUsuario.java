package com.pnis.api;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = { "http://localhost:8080", "http://pnis.ddns.net:8080" })
public class RestUsuario {
	
	@GetMapping("/usuario/{email}")
	public @ResponseBody String getUsuario(@PathVariable String email ) {
		
		return "SUCESS";
	}
	

}
