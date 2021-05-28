<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Empleados</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
	<link rel="stylesheet" type="text/css" href="style.css">
	
	
	<script type="text/javascript">
	$(document).ready(function (){
		
			$.post('ControllerShowEmpleados',{
				//Esta seccion es para enviar peticiones al servidor
				
				
			}, function (response){
				//Esta seccion es para recibir informacion
				let variable = JSON.parse(response);
				console.log(response);
				
				
				var tabla = document.getElementById('tablaDatos');
					for(let item of variable){
						
					tabla.innerHTML += `
					<tr>
						<td> ${item.idEmpleado} </td>
						<td> ${item.Nombre}&nbsp;${item.Apellido} </td>
						<td> ${item.Direccion} </td>
						<td> ${item.Telefono} </td>
						<td> ${item.Cargo} </td>
						<td> ${item.Departamento} </td>
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
				<table class="table2 table table-striped table-dark" id="tablaDatos">
					
					<thead>
						<tr>
						
							<th colspan="12"><h2 class="h7">Listado de Empleados</h2></th>
							
						</tr>
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							
							<th>Direcci&oacute;n</th>
							<th>Tel&eacute;fono</th>
							
							<th>Cargo</th>
							<th>Departamento</th>	
																			
							<th colspan="2">
								Opciones
							</th>
						</tr>
					</thead>
					<tbody>
					
					</tbody>
					
					&nbsp;
				</table>
			</div>
		</div>
	</div>
</body>

</html>