jQuery(function ($) {

	$("#login").on("click", function () {
		var params = {
            "nombre": $("#email").val(),
			"numeroIdentificacion": "123",
			"tipoDocumento": $("#password").val()
        };
		$.ajax({
            url: "http://pnis.ddns.net:8080/propietario",
            method: 'POST',
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(objectRequest)
		}).done(function (data){
			console.log('paola');
			console.log(data);
		});
	});

    $("#saveOwner").on("click", function () {
		var params = {
            "nombre": $("#nombre").val(),
            "numeroIdentificacion": $("#numeroIdentificacion").val(),
			"tipoDocumento": $("#tipoIdentificacion").val()
        };
		$.ajax({
            url: "http://pnis.ddns.net:8080/propietario",
            method: 'POST',
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(objectRequest)
		}).done(function (data){
			console.log('paola');
			console.log(data);
		});
	});
	
});