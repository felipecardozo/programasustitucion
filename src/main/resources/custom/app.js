$(document).ready(function () {

	$("#boton").on("click", function () {
		var objectRequest = {"nombre": "nuevo propietario",
			    "numeroIdentificacion": "1234567",
			    "tipoDocumento": "Cedula Ciudadania"};
		
		$.ajax({
            url: "http://localhost:8080/propietario",
            type: 'post',
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(objectRequest)
		}).success(function (result) {
			console.log(result);
		});
	});
	
});