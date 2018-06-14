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
			innerHtml.push(propietario.numeroIdentificacion);
			innerHtml.push("</td>");
			innerHtml.push("<td>");
			innerHtml.push(propietario.tipoDocumento);
			innerHtml.push("</td>");
		}
		tabla.html(innerHtml.join(""));
	});

    
	
});