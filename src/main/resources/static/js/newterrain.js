jQuery(function ($) {

	$("#crearterreno").on("submit", function (e) {
		var params = {
            "latitud": parseFloat($('#crearterreno input[name="latitud"]').val()),
		    "longitud": parseFloat($('#crearterreno input[name="longitud"]').val()),
		    "tamanio": parseInt($('#crearterreno input[name="tamanio"]').val()),
		    "nombre": $('#crearterreno input[name="nombre"]').val(),
		    "municipio": {
		    	"id": parseInt($('#crearterreno input[name="municipio.id"]').val())
		    },
		    "propietario": {
		    	"id": parseInt($('#crearterreno input[name="propietario.id"]').val())
		    }
        };
		$.ajax({
            url: "http://localhost:8080/terreno",
            method: 'POST',
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(params)
		}).done(function (data){
			alert("Terreno creado");
		});
		e.preventDefault();
	});

    
	
});