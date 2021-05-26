<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<meta charset="ISO-8859-1">
	<title>Proveedores</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>

<script type="text/javascript">
$(document).ready(function (){
		var label = document.getElementById('texto')
		$.post('ControllerProveedores'),{
			//Esta seccion es para enviar peticiones al servidor
			label
		}, function (response){
			//Esta seccion es para recibir informacion
			let datos = JSON.parse(response);
			//let datos = response.getAttribute("names");
			console.log(datos);
			//HACIENDO LA UNION DE CODIGO PARA MOSTRAR LOS DATOS
			
		};
	});
</script>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<table class="table2 table table-striped table-dark table-hover">
					
					<thead>
						<tr>
							<th colspan="7"><h2 class="h2">Listado de Proveedores</h2></th>
						</tr>
						<tr>
							<th>Nombre</th>
							<th>Contacto</th>
							<th>Tel&eacute;fono</th>
							<th>Direcci&oacute;n</th>
							<th>Correo</th>
							<th colspan="2">
								Opciones
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td><a href="" class="btn btn-danger">Eliminar</a></td>
							<td><a href="" class="btn btn-info">Actualizar</a></td>
						</tr>
						<tr>
							<td colspan="7">
								<a href="main.jsp" class="btn btn-success">Agregar</a>
								<a href="main.jsp" class="btn btn-warning">Cancelar</a>
							</td>
						</tr>
					</tbody>
					&nbsp;
				</table>
			</div>
		</div>
	</div>
	<label for="" id="texto">Prueba</label>
</body>

</html>