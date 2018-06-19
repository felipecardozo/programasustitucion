jQuery(function ($) {

    function getUrlParameter(sParam) {
        var sPageURL = decodeURIComponent(window.location.search.substring(1)),
            sURLVariables = sPageURL.split('&'),
            sParameterName,
            i;

        for (i = 0; i < sURLVariables.length; i++) {
            sParameterName = sURLVariables[i].split('=');

            if (sParameterName[0] === sParam) {
                return sParameterName[1] === undefined ? true : sParameterName[1];
            }
        }
    };
    //getTerrain by id
	var idTerrain = getUrlParameter('id');
	$.ajax({
        url: "http://localhost:8080/terreno/" + idTerrain,
        method: 'GET',
        dataType: "json",
        contentType: "application/json"
	}).done(function (data){
        $("#nombre").val(data.nombre);
        $("#latitud").val(data.latitud);
        $("#longitud").val(data.longitud);
        $("#tamanio").val(data.tamanio);
        $("#latitud").val(data.latitud);
        $("#idPropietario").val(data.propietario.id);
        $("#idMunicipio").val(data.municipio.id);
    });

    //editar terreno
    $("#editTerrain").on("submit", function (e) {
		var params = {
            "id": idTerrain,
            "latitud": parseFloat($('#editTerrain input[name="latitud"]').val()),
		    "longitud": parseFloat($('#editTerrain input[name="longitud"]').val()),
		    "tamanio": parseInt($('#editTerrain input[name="tamanio"]').val()),
		    "nombre": $('#editTerrain input[name="nombre"]').val(),
		    "municipio": {
		    	"id": parseInt($('#editTerrain input[name="municipio.id"]').val())
		    },
		    "propietario": {
		    	"id": parseInt($('#editTerrain input[name="propietario.id"]').val())
		    }
        };
		$.ajax({
            url: "http://localhost:8080/terreno",
            method: 'PUT',
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(params)
		}).done(function (data){
			alert("Terreno editado exitosamente!");
            window.location.href = 'terrains.html';
		});
		e.preventDefault();
	});
});