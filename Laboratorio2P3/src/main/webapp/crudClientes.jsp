<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title> Clientes </title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<script type="text/javascript">
					$(document).ready(function (){
						$.get('ControllerClientes',{
							//Esta seccion es para enviar peticiones al servidor
							
						}, function (response){
							//Esta seccion es para recibir informacion
							let datos = JSON.parse(response);
							console.log(datos);
							//HACIENDO LA UNION DE CODIGO PARA MOSTRAR LOS DATOS
							
						});
					});
				</script>
				<table class="table1 table-sm table-center table-striped table-dark table-hover" >
					<thead>
						<tr>
							<th colspan="15"><h2 class="h2"> Clientes </h2></th>
						</tr>
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							<th>Tipo</th>
							<th>Contacto</th>
							<th>Tel&eacute;fono</th>
							<th>Direcci&oacute;n</th>
							<th>Correo</th>
							<th>DUI</th>
							<th>NIT</th>
							<th>Nrc</th>	
							<th colspan="15"> Opciones </th>
						</tr>
						
					</thead>
					<tbody>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td><a href="" class="btn btn-danger">Eliminar</a></td>
							
						</tr>
						<tr>
						<td></td>
							<td></td>
							<td></td>
							<td colspan="7"><a href="" class="btn btn-success">Agregar</a>
								<a href="main.jsp" class="btn btn-warning">Menu</a></td>
							<td></td>
							<td></td>	
						</tr>
					</tbody>
					&nbsp;
				</table>
			</div>
		</div>
	</div>
</body>

</html>