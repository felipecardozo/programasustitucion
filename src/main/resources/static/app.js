jQuery(function ($) {

	$("#boton").on("click", function () {
		var objectRequest = {"nombre": "nuevo propietario",
			    "numeroIdentificacion": "123",
			    "tipoDocumento": "Cedula Ciudadania"};
		
		$.ajax({
            url: "http://pnis.ddns.net:8080/propietario",
            method: 'POST',
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(objectRequest)
		}).done(function (data){
			console.log(data);
			$(".span-class").html("creado");
		});
	});
	
});