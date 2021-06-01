<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.laboratorio2p3.entidades.Login" %>

<!DOCTYPE html>
<html>

<head>



<meta charset="ISO-8859-1">

<title> Clientes </title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
<link rel="stylesheet" type="text/css" href="style.css">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"
	integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"
	integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc"
	crossorigin="anonymous"></script>


</head>
</head>

<script type="text/javascript">
function cargar(Id) {
	$.post('ControllerClientes',{
		//Esta seccion es para enviar peticiones al servidor
		Id
	}, function (response){
		//Esta seccion es para recibir informacion
		let datos = JSON.parse(response);
		console.log(datos);
		
		
	});
}



	$(document).ready(function (){
		
			$.post('ControllerShowClientes',{
				//Esta seccion es para enviar peticiones al servidor
				
				
			}, function (response){
				//Esta seccion es para recibir informacion
				let variable = JSON.parse(response);
				console.log(response);
				
				
				var tabla = document.getElementById('tablaDatos');
					for(let item of variable){
						
					tabla.innerHTML += `
					<tr>
						<td class="align-middle"> ${item.IdCliente} </td>
						<td class="align-middle"> ${item.Nombre} </td>
						<td class="align-middle"> ${item.Tipo} </td>
						<td class="align-middle"> ${item.Contacto} </td>
						<td class="align-middle"> ${item.Telefono} </td>
						<td class="align-middle"> ${item.Direccion} </td>
						<td class="align-middle"> ${item.Correo} </td>
						<td class="align-middle"> ${item.Dui} </td>
						<td class="align-middle"> ${item.Nit} </td>
						<td class="align-middle"> ${item.Nrc} </td>
											
						<td><a href="ControllerShowClientes?Id=${item.IdCliente}&Eliminar=btne" class="btn btn-danger"><i class="fas fa-user-minus"></i>&nbsp; Eliminar </td>
						<td><a name="usu" href="add.jsp?Id=${item.idUsuario}&Usuario=${item.Usuario}&Pass=${item.PassWord}" class="btn btn-info"><i class="fas fa-user-edit"></i>&nbsp; Actualizar </td>						
					</tr>			
				`
				}
					
					
					
				tabla.innerHTML += `
					<tr>
						<td colspan="25">
						<a href="main.jsp" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal" type="button" id="button-addon2"> <i class="fas fa-user-plus"></i>&nbsp;> Agregar</a>
					    <a href="main.jsp" class="btn btn-warning" ><i class="fas fa-sign-out-alt"></i>&nbsp;Volver</a>
					    </td>
					</tr>
				`
			});
		});
	
	</script>
<body>


	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<table id="tablaDatos" class="table2 table table-striped table-dark">

					<thead>
						<tr>

							<th colspan="18"><h2 class="h4"> Clientes </h2></th>

						</tr>
						<tr>
						
							<th>Id</th>
							<th>Nombre</th>
							<th>Tipo</th>
							<th>Contacto</th>
							<th>Tel&eacute;fono</th>
							<th>Direcci&oacute;n</th>
							<th>Correo</th>
							<th>Dui</th>
							<th>Nit</th>
							<th>Nrc</th>
							<th></th>
							<th></th>
							<th colspan="2">Opciones </th>
							
							
						</tr>
					</thead>
					<tbody>

					</tbody>

					&nbsp;
				</table>
			</div>
		</div>
	</div>
	
	<!-- Modal Agregar-->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg modal-dialog-centered">
			<div class="modal-content bg-dark">
				<div class="modal-header">
					<h5 class="modal-title text-white" id="exampleModalLabel">Agregar</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Cancelar</button>
					<button type="button" class="btn btn-primary">Guardar</button>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>