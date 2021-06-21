<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.laboratorio2p3.entidades.Login"%>
<!DOCTYPE html>

<%
		//Retomando sesion
		HttpSession sesion = (HttpSession) request.getSession();
		Login log= (Login) sesion.getAttribute("log");
		
		//System.out.print( "Nombre usuario: "+log.getUser()+" ");
		
		if(log==null)
		{
			response.sendRedirect("index.jsp");
		}
	%>

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





<script type="text/javascript">
//Cristian
function resetDiv() {
	if(!$('#result').hasClass('oculto')){
		let form=document.getElementById('formEmpleado');
		form.reset();
		$('#result').addClass('oculto');
		$('#result').removeClass('bg-success bg-danger bg-warning');
		var tex=document.getElementById('texto');
		tex.innerText="";
	}
}
//Elmer
function cargarEmpleados() {
	$.post('ControllerShowEmpleados',{
		//Esta seccion es para enviar peticiones al servidor
		
	}, function (response){
		//Esta seccion es para recibir informacion
		let variable = JSON.parse(response);
		console.log(variable);

		var tabla = document.getElementById('tablaDatos');
		tabla.innerHTML = `
		<thead>
			<tr>
				<th colspan="15"><h2 class="h5">Listado de Empleados</h2></th>
			</tr>
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th class="oculto">Sexo</th>
				<th>Direcci&oacute;n</th>
				<th>Tel&eacute;fono</th>
				<th>Dui</th>
				<th>Nit</th>
				<th class="oculto">Cargo</th>
				<th>Departamento</th>
				<th colspan="2">Opciones</th>
			</tr>
		</thead>
		<tbody>

		</tbody>
		`
		for(let item of variable){
			
		tabla.innerHTML += `
			<tr>
				<td class="align-middle"> ${item.idEmpleado} </td>
				<td class="align-middle"> ${item.Nombre}&nbsp;${item.Apellido} </td>
				<td class="align-middle oculto"> ${item.Sexo} </td>
				<td class="align-middle"> ${item.Direccion} </td>
				<td class="align-middle"> ${item.Telefono} </td>
				<td class="align-middle"> ${item.Dui} </td>
				<td class="align-middle"> ${item.Nit} </td>
				<td class="align-middle oculto"> ${item.Cargo} </td>
				<td class="align-middle"> ${item.Departamento} </td>
				<td><a href="ControllerShowEmpleados?Id=${item.idEmpleado}&Eliminar=btne" class="btn btn-danger"> <i class="fas fa-user-minus"></i>&nbsp;Eliminar </td>
				<td> <a onclick="llenarform('${item.idEmpleado}','${item.Nombre}','${item.Apellido}',
					'${item.Sexo}','${item.Telefono}','${item.Dui}','${item.Nit}','${item.Cargo}','${item.Departamento}','${item.Direccion}' )" 
					name="emple" class="btn btn-info" data-bs-toggle="modal" 
					data-bs-target="#exampleModal" type="button" id="button-addon2"><i class="fas fa-user-edit"></i>&nbsp;Actualizar </td>		
			</tr>			
		`
			console.log(item.idEmpleado);
		}
		tabla.innerHTML += `
			<tr>
				<td colspan="25">
				<a href="main.jsp" onclick="resetDiv();" class="btn btn-success" data-bs-toggle="modal" data-bs-target="#exampleModal" type="button" id="button-addon2"> <i class="fas fa-user-plus"></i>&nbsp; Agregar</a>
				<a href="main.jsp" class="btn btn-warning" ><i class="fas fa-sign-out-alt"></i>&nbsp;Volver</a>
				</td>
			</tr>
		`
	});
}
//Kevin
function ejecutar(){
	resetDiv();
	//Obtencion de parametros
	let IdEmpleado=$('#id').val();
	let Nombre=$('#nombreEmple').val();
	let Apellido=$('#ApellidoEmple').val();
	let Sexo =$('#SexoEmple').val();
	let Direccion=$('#direc').val();
	let Telefono=$('#telef').val();
	let Dui=$('#DuiEmple').val();
	let Nit=$('#NitEmple').val();
	let Cargo=$('#CargoEmple').val();
	let Departamento=$('#DepartamentoEmple').val();

	let form=document.getElementById('formEmpleado');

	//Validacion si van vacios
	if(Nombre=="" || Apellido=="" || Sexo=="" || Direccion=="" || Telefono=="" || Dui=="" || Nit=="" || Cargo=="" || Departamento==""){

	}else{
		$.get('ControllerShowEmpleados',{
			//Esta seccion es para enviar peticiones al servidor
			IdEmpleado, Nombre, Apellido, Sexo, Direccion, Telefono, Dui, Nit, Cargo, Departamento
		}, function (response){
			//Esta seccion es para recibir informacion
			let datos = JSON.parse(response);
			console.log(datos);
			if(datos=="1"){
				var tex=document.getElementById('texto');
				tex.innerHTML="";
				$('#result').removeClass('oculto');
				$('#result').addClass('bg-success text-center');
				tex.innerHTML="Empleado almacenado con &eacute;xito";
				
				form.reset();
			} else if(datos=="2"){
				var tex=document.getElementById('texto');
				tex.innerHTML="";
				$('#result').removeClass('oculto');
				$('#result').addClass('bg-danger text-center');
				tex.innerHTML="Ocurri&oacute; un error al guardar";
				
				form.reset();
			}else if(datos=="3"){
				var tex=document.getElementById('texto');
				tex.innerHTML="";
				$('#result').removeClass('oculto');
				$('#result').addClass('bg-success text-center');
				tex.innerHTML="Empleado actualizado con &eacute;xito";
				form.reset();
			}else if(datos=="4"){
				var tex=document.getElementById('texto');
				tex.innerHTML="";
				$('#result').removeClass('oculto');
				$('#result').addClass('bg-danger text-center');
				tex.innerHTML="Ocurri&oacute; un error al actualizar";
				
				form.reset();
			}
			cargarEmpleados();
		});
	}
}
//Denis
$(document).ready(function (){
	cargarEmpleados();
});	
function llenarform(IdE,Nombre,Apellido,Sexo,Telefono,Dui,Nit,Cargo,Departamento,Direccion) 
{
	resetDiv();
	$('#id').val(IdE);
	$('#nombreEmple').val(Nombre)
	$('#ApellidoEmple').val(Apellido);
	$('#SexoEmple').val(Sexo);
	
	$('#telef').val(Telefono);
	$('#DuiEmple').val(Dui);
	$('#NitEmple').val(Nit);
	$('#CargoEmple').val(Cargo);
	$('#DepartamentoEmple').val(Departamento);
	$('#direc').val(Direccion);
}
	

	
</script>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<table class="table2 table table-sm table-striped table-dark mt-3" id="tablaDatos">

					
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
						<form action="" method="" id="formEmpleado">
							<div class="row">
								<input type="hidden" name="Id" id="id" value="0" disabled>
								<div class="col-lg-6 my-1">
									<label for="nombreEmple" class="form-label">Nombre:</label> <input
										required type="text" class="form-control" id="nombreEmple"
										name="Nombre" placeholder="Nombre de empleado">
								</div>
								<div class="col-lg-6 my-1">
									<label for="ApellidoEmple" class="form-label">Apellido:</label>
									<input required type="text" class="form-control"
										name="Apellido" id="ApellidoEmple"
										placeholder="Apellido de empleado">
								</div>
								<div class="col-lg-6 my-1">
									<label for="SexoEmple" class="form-label">Sexo:</label> 
									<input required type="text" name="Sexo" class="form-control"
										id="SexoEmple" placeholder="Sexo de empleado ">
								</div>
								<div class="col-lg-6 my-1">
									<label for="telef" class="form-label">Tel&eacute;fono:</label>
									<input required type="text" name="Telefono"
										class="form-control" id="telef" placeholder="Telefono del empleado">
								</div>
								<div class="col-lg-6 my-1">
									<label for="DuiEmple" class="form-label">Dui:</label> <input
										required type="text" name="Dui" class="form-control"
										id="DuiEmple" placeholder="">
								</div>
								<div class="col-lg-6 my-1">
									<label for="NitEmple" class="form-label">Nit:</label> <input
										required type="text" name="Nit" class="form-control"
										id="NitEmple" placeholder="">
								</div>
								<div class="col-lg-6 my-1">
									<label for="CargoEmple" class="form-label">Cargo:</label> <input
										required type="text" name="Cargo" class="form-control"
										id="CargoEmple" placeholder="">
								</div>
								<div class="col-lg-6 my-1">
									<label for="DepartamentoEmple" class="form-label">Departamento:</label> <input
										required type="text" name="Departamento"
										class="form-control" id="DepartamentoEmple" placeholder="">
								</div>
								<div class="col-lg-12 my-1">
									<label for="direccion" class="form-label">Direcci&oacute;n:</label>
									<textarea class="form-control" name="Direccion" id="direc"
										rows="3"></textarea>
								</div>
								<div class="bg-success col-10 offset-1 oculto" id="result">
									<div class="row justify-content-center text-white text-center">
										<p id="texto"></p>
									</div>
								</div>
							</div>

							<center class="mt-2 odal-footer col text-center">
								<button type="button" onclick="ejecutar()" name="Guardar" value="GUARDAR"
									class="btn btn-primary">
									<span class="fas fa-paper-plane"></span> &nbsp;Guardar
								</button>
							</center>

						</form>
					</div>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-danger"
						data-bs-dismiss="modal">
						<span class="fas fa-sign-out-alt"></span>Cerrar
					</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>