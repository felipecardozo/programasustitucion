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
    //getOwner by id
	var idOwner = getUrlParameter('id');
	$.ajax({
        url: "http://localhost:8080/propietario/" + idOwner,
        method: 'GET',
        dataType: "json",
        contentType: "application/json"
	}).done(function (data){
        $("#tipoIdentificacion").val(data.tipoDocumento);
        $("#numeroIdentificacion").val(data.numeroIdentificacion);
        $("#nombre").val(data.nombre);
    });

    //editar terreno
    $("#editOwner").on("submit", function (e) {
		var params = {
            "nombre": $('#editOwner input[id="nombre"]').val(),
			"numeroIdentificacion": parseInt($('#editOwner input[id="numeroIdentificacion"]').val()),
			"tipoDocumento": $("#tipoIdentificacion option:selected").text()
        };
		$.ajax({
            url: "http://localhost:8080/propietario",
            method: 'PUT',
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(params)
		}).done(function (data){
			alert("Propietario editado exitosamente!");
            window.location.href = 'owners.html';
		});
		e.preventDefault();
	});
});