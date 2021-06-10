<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	<%@ page import="com.laboratorio2p3.entidades.Login" %>
<!DOCTYPE html>
<%
		//Retomando sesion
		HttpSession sesion = (HttpSession) request.getSession();
		Login log= (Login) sesion.getAttribute("log");
		
		//System.out.print( "Nombre usuario: "+log.getUser()+" ");
		
		if(log==null){
			response.sendRedirect("index.jsp");
		}
	%>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Usuarios</title>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
	<link rel="stylesheet" type="text/css" href="style.css">
	
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
	
	
	<script type="text/javascript">
function llenarEmpleados() {
	$.post('ControllerCargarEmpleados',{
		//Esta seccion es para enviar peticiones al servidor
		
	}, function (response){
		//Esta seccion es para recibir informacion
		let datos = JSON.parse(response);
		console.log(datos);
		
		var lista = document.getElementById('listEmpleados');
		
		for(let item of datos){
			lista.innerHTML += `
			<option value="${item.idEmpleado}">${item.Nombre}</option>
			`
		}
	});
}
function ejecutar() {
	let IdUsuario =$('#id').val();
	let Empleado =document.getElementById('listEmpleados');
	let IdEmpleado=Empleado.value;
	let Usuario = $('#user').val();
	let Pass = $('#pass').val();
	let Tipos = document.getElementById('listTipo');
	let Tipo=Tipos.value;
	alert(IdUsuario);
	$.get('ControllerShowUsuarios',{
		//Esta seccion es para enviar peticiones al servidor
		IdUsuario, IdEmpleado, Usuario, Pass, Tipo
	}, function (response){
		//Esta seccion es para recibir informacion
		let datos = JSON.parse(response);
		console.log(datos);
		
	});
}

	$(document).ready(function (){
		llenarEmpleados();
		$.post('ControllerShowUsuarios',{
			//Esta seccion es para enviar peticiones al servidor
			
		}, function (response){
			//Esta seccion es para recibir informacion
			let datos = JSON.parse(response);
			console.log(datos);
			
			var tabla = document.getElementById('tablaDatos');
			
			for(let item of datos){
				tabla.innerHTML += `
				<tr>
					<td class="align-middle"> ${item.idUsuario} </td>
					<td class="align-middle"> ${item.Usuario} </td>
					
					<td class="align-middle"> ${item.Empleado.Nombre} </td>
					
					<td> <a href="ControllerShowUsuarios?IdUsuario=${item.idUsuario}&Eliminar=btne" class="btn btn-danger"><i class="fas fa-user-minus"></i>&nbsp;Eliminar </td>
					<td> <a name="usu" class="btn btn-info"><i class="fas fa-user-edit"></i>&nbsp;Actualizar </td>
				</tr>
				
			`
					
				console.log(item.Pass);
			}
			tabla.innerHTML += `
				<tr>
				<td colspan="20">
				<a href="main.jsp" class="btn btn-success"  data-bs-toggle="modal" data-bs-target="#exampleModal" type="button" id="button-addon2"><i class="fas fa-user-plus"></i>&nbsp;Agregar</a>
				<a href="main.jsp" class="btn btn-warning" ><i class="fas fa-sign-out-alt"></i>&nbsp;Cancelar</a>
				</tr>
				
		`
		});
	});
	
	</script>
	

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
					<h5 class="modal-title text-white" id="exampleModalLabel">Agregar</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body alert alert-success m-2" role="alert">
					<form action="" method="">
						<div class="row">
							<input type="hidden" name="Id" id="id" value="0" disabled>
							<div class="col-lg-6 my-1">
								<label for="listaE" class="form-label">Seleccione un Empleado:</label>
								<select class="form-control" aria-label="Default select example" name="listaE" id="listEmpleados">
								
								</select>
							</div>
							<div class="col-lg-6 my-1">
								<label for="contact" class="form-label">Usuario:</label>
								<input required type="text" class="form-control" name="usuario" id="user" placeholder="Escribe un nombre de Usuario">
							</div>
							<div class="col-lg-6 my-1">
								<label for="telef" class="form-label">Contrase&ntilde;a</label>
								<input required type="password" name="contra" class="form-control" id="pass" placeholder="Escriba una contrase&ntilde;a">
							</div>
							<div class="col-lg-6 my-1">
								<label for="listadoMarcas" class="form-label">Seleccione Tipo de Usuario</label>
								<select class="form-control" aria-label="Default select example" name="listaM" id="listTipo">
									<option value="1">Administrador</option>
									<option value="2">Usuario Standard</option>
								</select>
							</div>
							<div class="alert alert-success bg-success col-12 oculto" id="result">
								<div class="row justify-content-center text-white text-center">
									<p id="texto"> 
										
									</p>
								</div>
							</div>
						</div>
						<center class="mt-2">
							<button onclick="ejecutar()" type="button" class="btn btn-primary">
								<span class="fas fa-paper-plane"></span>
								Registrar Usuario
							</button>
						</center>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger"
						data-bs-dismiss="modal">Cancelar</button>
				</div>
			</div>
		</div>
	</div>
	
</body>

</html>