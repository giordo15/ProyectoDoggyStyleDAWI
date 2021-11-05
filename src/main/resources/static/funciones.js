function eliminar(id) {
	swal({
	  title: "Estas seguro de eliminar este registro?",
	  text: "Una vez eliminado, no podras recuperar este registro!",
	  icon: "warning",
	  buttons: true,
	  dangerMode: true,
	})
	.then((Ok) => {
	  if (Ok) {
		  $.ajax({
		  	url:"/views/usuarios/eliminar/"+id,
		  	success: function(res){
		  		console.log(res);
		  	} 		
		  });
	    swal("¡El registro ha sido eliminado!", {
	      icon: "success",
	    }).then((ok) => {
	    	if (ok) {
	    		location.href="/views/usuarios/listar";
	    	}
	    });
	  } else {
	    swal("¡El registro no ha sido eliminado!");
	  }
	});
}