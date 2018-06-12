jQuery( function($){

 /*$("#getUser").click( function(e){
        var usuario = {};
        usuario.email = "noreplay@domain.com";
        usuario.password = "1234567";
        $.ajax({
            url: "http://pnis.ddns.net:8080/login",
            type: "POST",
            data: JSON.stringify(usuario),
            success: function( data, textStatus, jQxhr ){
                console.log('paola', data);
            },
            error: function( jqXhr, textStatus, errorThrown ){
                console.log('error', errorThrown);
            }
        });
        //e.preventDefault();
    });*/

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

	$( "#postOwner" ).click( function( e ){
		add(e);

    });


    $( "#otroevento" ).click( function( e ){
		add(e);

    });

    $( "#evento2" ).click( function( e ){
		add(e);

    });

    function add(e){
        $.get( "http://pnis.ddns.net:8080/propietario/all", function( data ){
			console.log( "data" + data );
        });
        e.preventDefault();
    }
});
