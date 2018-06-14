package com.pnis.loader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.pnis.crud.MunicipioRepository;
import com.pnis.domain.Departamento;
import com.pnis.domain.Municipio;

public class LoaderMunicipios implements Loader {
	
	private MunicipioRepository municipioRepository;
	
	public LoaderMunicipios(MunicipioRepository municipioRepository) {
		this.municipioRepository = municipioRepository;
	}
	
	@Override
	public void loadFile() throws FileNotFoundException {
		File file = new File("C:\\Users\\rene.cardozo\\Documents\\Maestria\\I Semestre\\Software\\municipios.csv");
		Scanner sc = new Scanner(file);
		
		Municipio municipio = new Municipio();
		
		while( sc.hasNextLine() ) {
			String line = sc.nextLine();
			String input[] = line.split(",");
			municipio.setId(Integer.parseInt(input[0]));
			municipio.setNombre(input[1]);
			if( input.length>4 ) municipio.setLatitud(Double.parseDouble(input[4]));
			if( input.length>4 ) municipio.setLongitud(Double.parseDouble(input[5]));
			Departamento d = new Departamento();
			d.setId(Integer.parseInt(input[2]));
			municipio.setDepartamento(d);
			municipioRepository.save(municipio);
		}
		sc.close();
	}

}
