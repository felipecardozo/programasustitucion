package com.pnis.builder.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class WindowsFileBridge implements FileBridge{

	private String codigo;
	private Integer id;
	
	@Override
	public String buildArchivo(MultipartFile file) throws IOException {
		String archivo =  "C:\\AEM\\workspace\\programa-sustitucion\\uploads\\"+ codigo + "-"+ id +"-" + file.getOriginalFilename();
		File fileConverter = new File(archivo);
		fileConverter.createNewFile();
		FileOutputStream fileOutput = new FileOutputStream(fileConverter);
		fileOutput.write(file.getBytes());
		fileOutput.close();
		return archivo;
	}

	@Override
	public FileBridge buildCodigo(String codigo) {
		if( codigo != null ) {
			this.codigo = codigo;
		}
		return this;
	}

	@Override
	public FileBridge buildIdFile(Integer id) {
		if( id != null ) {
			this.id = id;
		}
		return this;
	}

}
