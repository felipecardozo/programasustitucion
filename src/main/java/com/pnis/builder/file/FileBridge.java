package com.pnis.builder.file;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface FileBridge {
	
	public FileBridge buildCodigo(String codigo);
	
	public FileBridge buildIdFile(Integer id);
	
	public String buildArchivo(MultipartFile file)  throws IOException;

}
