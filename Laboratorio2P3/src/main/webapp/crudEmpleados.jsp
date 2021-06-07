<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ page import="com.laboratorio2p3.entidades.Login" %>	

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Empleados</title>






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

<%
String IdEmpeado = request.getParameter("idEmpleado");
String Nombre = request.getParameter("Nombre");
String Apellido = request.getParameter("Apellido");
String Sexo = request.getParameter("Sexo");
String Direccion = request.getParameter("Direccion");
String Telefono = request.getParameter("Telefono");
String Dui = request.getParameter("Dui");
String Nit = request.getParameter("Nit");
String Cargo = request.getParameter("Cargo");
String Departamento = request.getParameter("Departamento");

if (IdEmpeado == null) {
	IdEmpeado = "";
	Nombre = "";
	Apellido = "";
	Sexo = "";
	Direccion = "";
	Telefono = "";
	Dui = "";
	Nit = "";
	Cargo = "";
	Departamento = "";

}
%>



<script type="text/javascript">
function cargar(Id) {
	$.post('ControllerEmpleados',{
		//Esta seccion es para enviar peticiones al servidor
		Id
	}, function (response){
		//Esta seccion es para recibir informacion
		let datos = JSON.parse(response);
		console.log(datos);
		
		
	});
}





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
						<td class="align-middle"> ${item.idEmpleado} </td>
						<td class="align-middle"> ${item.Nombre}&nbsp;${item.Apellido} </td>
						<td class="align-middle"> ${item.Direccion} </td>
						<td class="align-middle"> ${item.Telefono} </td>
						<td class="align-middle"> ${item.Cargo} </td>
						<td class="align-middle"> ${item.Departamento} </td>
											
						<td><a href="ControllerShowEmpleados?Id=${item.idEmpleado}&Eliminar=btne" class="btn btn-danger"><i class="fas fa-user-minus"></i>&nbsp; Eliminar </td>
						<td><a href="add.jsp?Id=${item.idUsuario}&Empleado=${item.Nombre}&Pass=${item.PassWord}" class="btn btn-info"><i class="fas fa-user-edit"></i>&nbsp;Actualizar </td>						
					</tr>			
				`
						console.log(item.idEmpleado);
				
				}
					
					
					
				tabla.innerHTML += `
					<tr>
						<td colspan="20">
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
							<th colspan="2">Opciones</th>
							
							
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
					<h5 class="modal-title text-white" id="exampleModalLabel">Agregar Empleado</h5>					
				</div>
				
				
				
				<div class="modal-body alert alert-success m-2" role="alert">
					<div class="col-12">
						<form action="" method="">
						
						
							<div class="row">
								<input type="hidden" name="Id" id="id" value="0" disabled>
								
								
								<div class="col-lg-6 my-1">
									<label for="nombreEmple" class="form-label">Nombre:</label>
									<input required type="text" class="form-control" id="nombreEmple" name="Nombre" placeholder="Nombre de empleado">
								</div>
								
								
								<div class="col-lg-6 my-1">
									<label for="ApellidoEmple" class="form-label">Apellido:</label>
									<input required type="text" class="form-control" name="Apellido" id="ApellidoEmple" placeholder="Apellido de empleado">
								</div>
								
								
								<div class="col-lg-6 my-1">
									<label for="Sexo" class="form-label">Sexo:</label>
									<input required type="text" name="SexoEmple" class="form-control" id="Sexo" placeholder=" ">
								</div>
								
												
								
								<div class="col-lg-6 my-1">
									<label for="correo" class="form-label">Tel&eacute;fono:</label>
									<input required type="text" name="Telefono" class="form-control" id="telef" placeholder="">
								</div>
								
								
								<div class="col-lg-6 my-1">
									<label for="nit" class="form-label">Dui:</label>
									<input required type="text" name="DuiEmple"  class="form-control" id="Dui" placeholder="">
								</div>
								
								
									<div class="col-lg-6 my-1">
									<label for="nrc" class="form-label">Nit:</label>
									<input required type="text" name="NitEmple"  class="form-control" id="Nit" placeholder="">
								</div>
								
								
								
								<div class="col-lg-6 my-1">
									<label for="nrc" class="form-label">Cargo:</label>
									<input required type="text" name="CargoEmple"  class="form-control" id="Cargo" placeholder="">
								</div>
								
								
								<div class="col-lg-6 my-1">
									<label for="nrc" class="form-label">Departamento:</label>
									<input required type="text" name="DepartamentoEmple"  class="form-control" id="Departamento" placeholder="">
								</div>
								
								
								<div class="col-lg-12 my-1">
									<label for="direccion" class="form-label">Direcci&oacute;n:</label>
									<textarea class="form-control" name="Direccion" id="direc" rows="3"></textarea>
								</div>
								
																					
																			
								<div class="alert bg-success col-12 oculto" id="result">
									<div class="row justify-content-center text-white text-center">
										<p id="texto"> 
											
										</p>
									</div>
								</div>
								
							</div>
							
							
							<center class="mt-2">
								<button onclick="ejecutar()" type="button" class="btn btn-primary"><span class="fas fa-paper-plane"></span>Registrar Empleado</button>
							</center>
							
							
						</form>
					</div>
				</div>
				
				
				<div class="modal-footer">					
					<button type="button" class="btn btn-danger" data-bs-dismiss="modal"><span class="fas fa-sign-out-alt"></span>Close</button>
				</div>
				
				
			
			
			</div>
		</div>
	</div>
	
</body>
</html>