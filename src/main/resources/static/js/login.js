jQuery(function ($) {

	$("#login").on("click", function (e) {
		var params = {
            "email": $("#email").val(),
			"password": $("#password").val()
        };
		$.ajax({
            url: "http://localhost:8080/login",
            method: 'POST',
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(params)
		}).done(function (data){
			console.log('paola');
			console.log(data);
		});
		//e.preventDefault();
	});

    $("#saveOwner").on("click", function (e) {
		var params = {
            "nombre": $("#nombre").val(),
            "numeroIdentificacion": $("#numeroIdentificacion").val(),
			"tipoDocumento": $("#tipoIdentificacion").val()
        };
		$.ajax({
            url: "http://localhost:8080/propietario",
            method: 'POST',
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(params)
		}).done(function (data){
			console.log('paola');
			console.log(data);
		});
		e.preventDefault();
	});
	
});