jQuery(function ($) {
	var tabla = $("#tabla_terrenos");

	$.ajax({
        url: "http://localhost:8080/sustituciones",
        method: 'GET',
        dataType: "json",
        contentType: "application/json"
	}).done(function (data){
		var innerHtml = [];

		for(var i=0; i<data.length; i++){
			var sustitucion = data[i];

			innerHtml.push("<tr>");
			innerHtml.push("<td>");
			innerHtml.push(sustitucion.id);
			innerHtml.push("</td>");
			innerHtml.push("<td>");
			innerHtml.push(sustitucion.fechaInicio);
			innerHtml.push("</td>");
			innerHtml.push("<td>");
			innerHtml.push(sustitucion.fechaFin);
			innerHtml.push("</td>");
			innerHtml.push("<td>");
			innerHtml.push(sustitucion.estado);
			innerHtml.push("</td>");
			innerHtml.push("<td>");
			innerHtml.push(sustitucion.delegado);
			innerHtml.push("</td>");
			innerHtml.push("<td>");
			innerHtml.push(terreno.terreno);
			innerHtml.push("</td>");
			innerHtml.push("<td>");
			innerHtml.push(terreno.tipoSustitucion);
			innerHtml.push("</td>");
			innerHtml.push("<td>");
			innerHtml.push("<td>");
			innerHtml.push(terreno.acuerdo);
			innerHtml.push("</td>");
			innerHtml.push("<td>");
			innerHtml.push("<a class='btn btn-info' href='/editsustitucion.html?id=" + terreno.id + "'>Editar</a>");
			innerHtml.push("</td>");
			innerHtml.push("<td>");
			innerHtml.push("<input type='button' class='btn btn-warning' onclick='eliminar(" + sustitucion.id + ")' id='deleteTerrain' value ='Eliminar'>");
			innerHtml.push("</td>");
			innerHtml.push("</tr>");
		}
		tabla.html(innerHtml.join(""));
	});	
});

function eliminar(id){
	if(confirm("¿Está usted seguro de que desear eliminar esta sustitucion?")){
		$.ajax({
            url: "http://localhost:8080/terreno/" + id,
            method: 'DELETE',
            dataType: "json",
            contentType: "application/json"
		}).done(function (data){
			alert("¡Sustitucion eliminada correctamente!");
			window.location.href = location;
		});
	}
	else{
		return false;
	}
}