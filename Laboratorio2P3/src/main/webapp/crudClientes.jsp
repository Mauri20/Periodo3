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
											
						<td><a href="ControllerShowClientes?Id=${item.IdCliente}&Eliminar=btne" class="btn btn-danger"><i class="fas fa-trash-alt"></i></i>&nbsp; Eliminar </td>
						<td><a name="usu" href="add.jsp?Id=${item.idUsuario}&Usuario=${item.Usuario}&Pass=${item.PassWord}" class="btn btn-info"><i class="fas fa-pen-square"></i></i>&nbsp; Actualizar </td>						
					</tr>		
					
					
				`
				}
					
			
					
				tabla.innerHTML += `
					<tr>
						<td colspan="25">
						<a href="main.jsp" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal" type="button" id="button-addon2"> <i class="fas fa-external-link-alt"></i></i>&nbsp; Agregar </a>
					    <a href="main.jsp" class="btn btn-warning" ><i class="fas fa-home"></i>&nbsp; Menu </a>
					    </td>
					</tr>
				`
			});
		});
	
		$("btne").click(function (){
					swal({
					title: "Estas seguro?",
					text: "Una vez eliminado, no podras recuperar este archivo!",
					icon: "warning",
					buttons: true,
					dangerMode: true,
					})
					.then((willDelete) => {
					if (willDelete) {
						swal("El archivo ha sido eliminado!", {
						icon: "success",
						});
					} else {
						swal("Operacion cancelada!");
					}
					});	
				});
	
	</script>
	
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<table id="tablaDatos" class="table2 table-center table-sm table-striped table-dark">

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
		<div class="modal-dialog modal-lg modal-dialog-centered modal-dark">
			<div class="modal-content  bg-muted modalA">
				<div class="modal-header">
				
					<h6 class="modal-title text-black font-weight-bold It�lica text-dark col text-center" id="exampleModalLabel">AGREGAR</h6>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form action="" method="">
					<div class="row">
					<input type="hidden" name="Id" id="id" value="0" disabled>
								<div class="col-lg-6 my-1">
									<label for="Nombre" class="form-label">Nombre:</label>
									<input required type="text" class="form-control" id="NombreCliente" name="Nombre" placeholder="Ferreteria San Jose">
								</div>
								<div class="col-lg-6 my-1">
									<label for="Tipo" class="form-label">Tipo:</label>
									<input required type="text" class="form-control" name="Contacto" id="Tipo" placeholder="Juridico">
								</div>
								<div class="col-lg-6 my-1">
									<label for="Contacto" class="form-label">Contacto:</label>
									<input required type="text" class="form-control" name="Contacto" id="Contacto" placeholder="Juan Perez">
								</div>
								
								<div class="col-lg-6 my-1">
									<label for="telefono" class="form-label">Tel&eacute;fono:</label>
									<input required type="text" name="Telefono" class="form-control" id="telefono" placeholder="(503)2352-7823">
								</div>
								<div class="col-lg-12 my-1">
									<label for="Direccion" class="form-label">Direcci&oacute;n:</label>
									<textarea class="form-control" name="Direccion" id="Direccion" rows="3"></textarea>
								</div>
								<div class="col-lg-6 my-1">
									<label for="Correo" class="form-label">Correo:</label>
									<input required type="text" name="Correo" class="form-control" id="Correo" placeholder="name@example.com">
								</div>
								<div class="col-lg-6 my-1">
									<label for="Dui" class="form-label">Dui:</label>
									<input required type="text" name="Dui"  class="form-control" id="Dui" placeholder="12345678-9">
								</div>
								<div class="col-lg-6 my-1">
									<label for="Nit" class="form-label">Nit:</label>
									<input required type="text" name="Nit"  class="form-control" id="Nit" placeholder="1234-123456-123-1">
								</div>
								<div class="col-lg-6 my-1">
									<label for="Nrc" class="form-label">Nrc:</label>
									<input required type="text" name="Nrc"  class="form-control" id="Nrc" placeholder="123456-1">
								</div>
								
							<center class="mt-2 odal-footer col text-center">
								<button onclick="ejecutar()" type="button" class="btn btn-success">
									<span class="fas fa-badge-check"></span>
									Guardar
								</button>
							</center>	
					</form>
				</div>
    						
				<div class="modal-footer">
					<button type="button" class="btn btn-danger regular-button"
						data-bs-dismiss="modal">
						<span class="fas fa-times"></span>
						Cancelar
					</button>
				</div>
				
			</div>
		</div>
	</div>
	
</body>
</html>