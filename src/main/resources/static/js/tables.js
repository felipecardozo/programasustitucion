jQuery(function ($) {

	var tabla = $("#tabla_sustitucion");

	$.ajax({
        url: "http://localhost:8080/sustituciones",
        method: 'GET',
        dataType: "json",
        contentType: "application/json"
	}).done(function (data){
		var innerHtml = [];
		for( var i=0; i<data.length; i++ ){
			var sustitucion = data[i];
			console.log(sustitucion);
			
			innerHtml.push("<tr>");
			innerHtml.push("<td>");
			innerHtml.push(sustitucion.terreno.nombre);
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
			innerHtml.push(sustitucion.tipoSustitucion.nombre);
			innerHtml.push("</td>");
			innerHtml.push("</tr>");
		}
		tabla.html(innerHtml.join(""));
	});

    
	
});