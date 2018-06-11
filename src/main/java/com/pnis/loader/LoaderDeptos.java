package com.pnis.loader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.pnis.crud.DepartamentosRepository;
import com.pnis.domain.Departamento;

@Component
public class LoaderDeptos implements Loader {
	
	private DepartamentosRepository departamentosRepository;
	
	public LoaderDeptos(DepartamentosRepository departamentosRepository) throws FileNotFoundException {
		this.departamentosRepository = departamentosRepository;
	}
	
	@Override
	public void loadFile() throws FileNotFoundException {
		File file = new File("C:\\Users\\rene.cardozo\\Documents\\Maestria\\I Semestre\\Software\\departamentos.csv");
		Scanner sc = new Scanner(file);
		
		Departamento departamento = new Departamento();
		
		while( sc.hasNextLine() ) {
			String line = sc.nextLine();
			String input [] = line.split(",");
			System.out.println(input[0] + " - " + input[1]);
			departamento.setId(Integer.parseInt(input[0]));
			departamento.setNombre(input[1]);
			departamento.setLatitud(Double.parseDouble(input[2]));
			departamento.setLongitud(Double.parseDouble(input[3]));
			departamento.setIdPais(1);
			departamentosRepository.save(departamento);
		}
		sc.close();
	}

}
