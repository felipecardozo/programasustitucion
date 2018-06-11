package com.pnis.api;

import java.io.FileNotFoundException;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pnis.crud.DepartamentosRepository;
import com.pnis.crud.MunicipioRepository;
import com.pnis.loader.Loader;
import com.pnis.loader.LoaderDeptos;
import com.pnis.loader.LoaderMunicipios;

/**
 * This class will run only 1 time. </br>
 * Once the data is loaded in the data base for departamentos and for municipios </br>
 * is not required to run it again.
 * */
@RestController
public class RestLoader {
	
	@Autowired
	private DepartamentosRepository departamentosRepository;
	
	@Inject
	private MunicipioRepository municipioRepository;
	
	@GetMapping(path="/departamentos")
	public @ResponseBody String loadDepartamentos() {
		try {
			Loader loader = new LoaderDeptos(departamentosRepository);
			loader.loadFile();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return "SUCESS";
	}
	
	@GetMapping(value="/municipios")
	public String loadMunicipios() {
		try {
			LoaderMunicipios loader = new LoaderMunicipios(municipioRepository);
			loader.loadFile();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return "SUCESS";
	}

}
