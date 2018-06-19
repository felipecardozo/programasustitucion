jQuery(function ($) {
	var tabla = $("#tabla_terrenos");

	$.ajax({
        url: "http://localhost:8080/terrenos",
        method: 'GET',
        dataType: "json",
        contentType: "application/json"
	}).done(function (data){
		var innerHtml = [];

		for(var i=0; i<data.length; i++){
			var terreno = data[i];

			innerHtml.push("<tr>");
			innerHtml.push("<td>");
			innerHtml.push(terreno.nombre);
			innerHtml.push("</td>");
			innerHtml.push("<td>");
			innerHtml.push(terreno.latitud);
			innerHtml.push("</td>");
			innerHtml.push("<td>");
			innerHtml.push(terreno.longitud);
			innerHtml.push("</td>");
			innerHtml.push("<td>");
			innerHtml.push(terreno.tamanio);
			innerHtml.push("</td>");
			innerHtml.push("<td>");
			innerHtml.push(terreno.propietario.nombre);
			innerHtml.push("</td>");
			innerHtml.push("<td>");
			innerHtml.push(terreno.municipio.nombre);
			innerHtml.push("</td>");
			innerHtml.push("<td>");
			innerHtml.push(terreno.municipio.departamento.nombre);
			innerHtml.push("</td>");
			innerHtml.push("<td>");
			innerHtml.push("<a class='btn btn-info' href='/editterrain.html?id=" + terreno.id + "'>Editar</a>");
			innerHtml.push("</td>");
			innerHtml.push("<td>");
			innerHtml.push("<input type='button' class='btn btn-warning' onclick='eliminar("+terreno.id+")' id='deleteTerrain' value ='Eliminar'>");
			innerHtml.push("</td>");
			innerHtml.push("</tr>");
		}
		tabla.html(innerHtml.join(""));
	});	
});

function eliminar(id){
	if(confirm("¿Está usted seguro de que desear eliminar este terreno?")){
		$.ajax({
            url: "http://localhost:8080/terreno/" + id,
            method: 'DELETE',
            dataType: "json",
            contentType: "application/json"
		}).done(function (data){
			alert("Terreno eliminado correctamente!");
			window.location.href = location;
		});
	}
	else{
		return false;
	}
}