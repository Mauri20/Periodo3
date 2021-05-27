<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Usuarios</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
	<link rel="stylesheet" type="text/css" href="style.css">
	
	<script type="text/javascript">
	$(document).ready(function (){
		
		$.get('ControllerUsuarios',{
			
			//Esta seccion es para enviar peticiones al servidor
			
		}, function (response){
			//Esta seccion es para recibir informacion
			let datos = JSON.parse(response);
			console.log(datos);
			
			
			var tabla = document.getElementById('tablaDatos');
			
			for(let item of datos){
				
			tabla.innerHTML += `
			<tr>
				<td> ${item.idUsuario} </td>
				<td> ${item.Usuario} </td>
				
				<td> ${item.nombre} </td>
				
				 
			
				<td> <a href="ControllerMostrarInformacion?IdUsuario=${item.idUsuario}&Eliminar=btne" class="btn btn-danger">Eliminar </td>
				<td> <a name="usu" href="add.jsp?Id=${item.idUsuario}&Usuario=${item.Usuario}&Pass=${item.PassWord}" class="btn btn-warning">Actualizar </td>
			</tr>
			
		`
				
			console.log(item.Pass);
		}
		tabla.innerHTML += `
			<tr>
				<td colspan="20"><a href="main.jsp" class="btn btn-success">Agregar</a>
					<a href="main.jsp" class="btn btn-warning">Volver</a></td>
			</tr>
			
		`
			
		});
	});
	</script>
	
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<table id="tablaDatos" class="table2 table table-striped table-dark table-hover">
					
					<thead>
						<tr>
							<th colspan="7"><h2 class="h2">Listado de usuarios</h2></th>
						</tr>
						<tr>
							<th>idUsuario</th>
							<th>Usuario</th>
							<th>Nombre</th>
							
								
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
					
					</tbody>
					&nbsp;
				</table>
			</div>
		</div>
	</div>
</body>

</html>