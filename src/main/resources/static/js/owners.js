jQuery(function ($) {
	var tabla = $("#tabla_propietarios");

	$.ajax({
        url: "http://localhost:8080/propietarios",
        method: 'GET',
        dataType: "json",
        contentType: "application/json"
	}).done(function (data){
		var innerHtml = [];

		for( var i=0; i<data.length; i++ ){
			var propietario = data[i];
			
			innerHtml.push("<tr>");
			innerHtml.push("<td>");
			innerHtml.push(propietario.nombre);
			innerHtml.push("</td>");
			innerHtml.push("<td>");
			innerHtml.push(propietario.tipoDocumento);
			innerHtml.push("</td>");
			innerHtml.push("<td>");
			innerHtml.push(propietario.numeroIdentificacion);
			innerHtml.push("</td>");
			innerHtml.push("<td>");
			innerHtml.push("<a class='btn btn-info' href='/editowner.html?id=" + propietario.numeroIdentificacion + "'>Editar</a>");
			innerHtml.push("</td>");
			innerHtml.push("<td>");
			innerHtml.push("<input type='button' class='btn btn-warning' onclick='eliminar(" + propietario.numeroIdentificacion + ")' id='deleteOwner' value ='Eliminar'>");
			innerHtml.push("</td>");
			innerHtml.push("</tr>");
		}
		tabla.html(innerHtml.join(""));
	});
});

function eliminar(numeroIdentificacion){
	if(confirm("¿Está usted seguro de que desear eliminar este propietario?")){
		$.ajax({
            url: "http://localhost:8080/propietario/" + numeroIdentificacion,
            method: 'DELETE',
            dataType: "json",
            contentType: "application/json"
		}).done(function (data){
			alert("¡Propietario eliminado correctamente!");
			window.location.href = location;
		});
	}
	else{
		return false;
	}
}