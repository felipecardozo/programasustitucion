jQuery(function ($) {

	var tabla = $("#tabla_terrenos");

	$.ajax({
        url: "http://localhost:8080/terrenos",
        method: 'GET',
        dataType: "json",
        contentType: "application/json"
	}).done(function (data){
		var innerHtml = [];
		for( var i=0; i<data.length; i++ ){
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
		}
		tabla.html(innerHtml.join(""));
	});

    
	
});