package com.pnis.api;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pnis.dto.FileDTO;

@RestController
public class RestFileManager {

	//https://spring.io/guides/gs/uploading-files/
	@PostMapping(value="/upload", consumes= MediaType.MULTIPART_FORM_DATA_VALUE)
	public @ResponseBody FileDTO uploadFile( @RequestParam MultipartFile file ) throws IOException {
		File fileConverter = new File( "C:\\AEM\\workspace\\programa-sustitucion\\uploads\\" + file.getOriginalFilename() );
		fileConverter.createNewFile();
		FileOutputStream fileOutput = new FileOutputStream(fileConverter);
		fileOutput.write(file.getBytes());
		fileOutput.close();
		return new FileDTO("File has been uploaded");
	}
	
}
