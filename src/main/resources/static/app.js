jQuery(function ($) {

	$("#boton").on("click", function (e) {
		var objectRequest = {
			"email": "algo@algo.com",
			"password": "2345678"
		};
		
		$.ajax({
            url: "http://localhost:8080/login",
            method: 'POST',
            dataType: "json",
            contentType: "application/json",
            data: JSON.stringify(objectRequest)
		}).done(function (data){
			console.log(data);
		});
		e.preventDefault();
	});
	
});