jQuery(function ($) {
	$("#saveowner").on("submit", function (e) {
		var params = {
			"nombre": $('#saveowner input[id="nombre"]').val(),
			"numeroIdentificacion": parseInt($('#saveowner input[id="numeroIdentificacion"]').val()),
			"tipoDocumento": $("#tipoIdentificacion option:selected").text()
        };
		$.ajax({
			url: "http://localhost:8080/propietario",
			method: 'POST',
			dataType: "json",
			contentType: "application/json",
			data: JSON.stringify(params)
		}).done(function (data){
			alert("Propietario creado exitosamente!");
			window.location.href = 'owners.html';
		});
		e.preventDefault();
	});
});