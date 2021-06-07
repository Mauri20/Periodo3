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
<title>Proveedores</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
<link rel="stylesheet" type="text/css" href="style.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
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
function cargar(Id) {
	$.post('ControllerProveedores',{
		//Esta seccion es para enviar peticiones al servidor
		Id
	}, function (response){
		//Esta seccion es para recibir informacion
		let datos = JSON.parse(response);
		console.log(datos);
		
		var tabla = document.getElementById('tablaModal');
		tabla.innerHTML=``;
		tabla.innerHTML=`
			<thead>
				<tr>
					<th class="bg-secondary">Marcas</th>
				</tr>
			</thead>
		`;
		for(let item of datos){
			
			
			tabla.innerHTML += `
			<thead>
				<tr>
					<td class="align-middle"> ${item.NombreMarca} </td>
				</tr>
			</thead>
			`
		}
	});
}
function llenarMarcas() {
	$.post('ControllerMarcas',{
		//Esta seccion es para enviar peticiones al servidor
		
	}, function (response){
		//Esta seccion es para recibir informacion
		let datos = JSON.parse(response);
		console.log(datos);
		
		var lista = document.getElementById('listadoMarcas');
		
		for(let item of datos){
			lista.innerHTML += `
			<option value="${item.Id}">${item.NombreMarca}</option>
			`
		}
	});
}
function ejecutar() {
	var texto=document.getElementById('texto');
	if(document.getElementById('tablaMarcas').rows.length>1){
		
		arregloTabla();

		let Id=$('#id').val()
		let Nombre=$('#nombreProv').val()
		let Contacto=$('#contact').val()
		let Telefono=$('#telef').val()
		let Email=$('#correo').val()
		let Nit=$('#nit').val()
		let Nrc=$('#nrc').val()
		let Direccion=$('#direc').val()
		
		$.get('ControllerShowProveedores',{
		//Esta seccion es para enviar peticiones al servidor
			
			Id, Nombre, Contacto, Telefono, Email, Nit, Nrc, Direccion

		}, function (response){
			//Esta seccion es para recibir informacion
			let datos= JSON.parse(response);
			console.log(datos);
		});
	}else{
		if($('#result').hasClass('oculto')){
			$('#result').removeClass('oculto');
			$('#result').addClass('bg-danger');
			texto.innerHTML="Debe agregar Marcas para el Proveedor!";
		}
	}
}
function recorrerTabla(){
	let marc;
	let tab=document.getElementById('tablaMarcas');
	
	for (var i = 1, row; row = tab.rows[i]; i++) {
	//alert(cell[i].innerText);
		marc=row.cells[0].innerText;
		console.log(marc);
		$.get('ControllerShowProveedores',{
		//Esta seccion es para enviar peticiones al servidor
			marc
		}, function (response){
			//Esta seccion es para recibir informacion
			
		});
	}
	
}
function loadProv(){
	$.post('ControllerShowProveedores',{
		//Esta seccion es para enviar peticiones al servidor
		
	}, function (response){
		//Esta seccion es para recibir informacion
		let datos = JSON.parse(response);
		console.log(datos);
		
		var tabla = document.getElementById('tablaDatos');
		for(let item of datos){
			
			
			tabla.innerHTML += `
				<tr>
					<td class="align-middle"> ${item.Id} </td>
					<td class="align-middle"> ${item.Nombre} </td>
					<td class="align-middle"> ${item.Contacto} </td>
					<td class="align-middle"> ${item.Telefono} </td>
					<td class="align-middle"> ${item.Direccion} </td>
					<td class="align-middle"> ${item.Correo} </td>
					<td class="align-middle"> <a data-bs-toggle="modal" data-bs-target="#modalMarcas" type="button" id="button-addon2"  class="btn btn-secondary" onClick="cargar(${item.Id})" id="marcas${item.Id}"><i class="fas fa-list"></i>&nbsp;Ver</a> </td>
					<td><a href="ControllerShowProveedores?Id=${item.Id}&Eliminar=btne" class="btn btn-danger"><i class="fas fa-user-minus"></i>&nbsp; Eliminar </td>
					<td><a name="usu" href="add.jsp?Id=${item.idUsuario}&Usuario=${item.Usuario}&Pass=${item.PassWord}" class="btn btn-info"><i class="fas fa-user-edit"></i>&nbsp;Actualizar </td>
				</tr>
			`
				
		}
		
		tabla.innerHTML += `
			<tr>
				<td colspan="9">
				<a href="main.jsp" class="btn btn-success"  data-bs-toggle="modal" data-bs-target="#exampleModal" type="button" id="button-addon2"><i class="fas fa-user-plus"></i>&nbsp;Agregar</a>
				<a href="main.jsp" class="btn btn-warning" ><i class="fas fa-sign-out-alt"></i>&nbsp;Cancelar</a>
				
				</td>
			</tr>
		`
	});
}
$(document).ready(function (){
	loadProv();
	llenarMarcas();
	});
	
function addRow(){
	if(!$('#result').hasClass('oculto')){
		var tex=document.getElementById('texto');
		$('#result').removeClass('bg-danger');
		$('#result').addClass('oculto');
		tex.innerHTML="";
	}
	let opc=document.getElementById('listadoMarcas');
	let valor=opc.value;
	let texto=$('select[id="listadoMarcas"] option:selected').text();
	let tabla=document.getElementById('tablaMarcas');
	tabla.innerHTML+=`
		<tr id="row${valor}">
			<td class="align-middle id">${valor}</td>
			<input type="hidden" name="marcaId" id="marcaId" value="${valor}">
			<td class="align-middle nombreMarca">${texto}</td>
			<td class="align-middle"><button onclick="removeRow('row${valor}')" type="button" class="btn btn-danger"><i class="fas fa-minus-square"></i></button></td>
		</tr>
	`
}
function removeRow(id){
	$('#'+id).remove();
}
function arregloTabla(){
	
	let marcas = [];

	document.querySelectorAll('.tabla-arreglo tbody tr').forEach(function(e){
	let fila = {
		id: e.querySelector('.id').innerText
	};
	marcas.push(fila);
	});

	console.log(marcas);
	$.get('ControllerPruebas',{
	//Esta seccion es para enviar peticiones al servidor
		marcas
	}, function (response){
		//Esta seccion es para recibir informacion
		
	});
}
</script>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<table id="tablaDatos" class="table2 table-sm table table-dark table-striped">

					<thead>
						<tr>
							<th colspan="9"><h2 class="h2">Listado de Proveedores</h2></th>
						</tr>
						<tr class="bg-dark">
							<th>Id</th>
							<th>Nombre</th>
							<th>Contacto</th>
							<th>Tel&eacute;fono</th>
							<th>Direcci&oacute;n</th>
							<th>Correo</th>
							<th>Marcas</th>
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
		<div class="modal-dialog modal-lg modal-dialog-centered modal-dialog-scrollable">
			<div class="modal-content bg-dark modalA">
				<div class="modal-header">
					<h5 class="modal-title text-white" id="exampleModalLabel">Registro de Proveedores</h5>
				</div>
				<div class="modal-body alert alert-success m-2" role="alert">
					<div class="col-12">
						<form action="" method="">
							<div class="row">
								<input type="hidden" name="Id" id="id" value="0" disabled>
								<div class="col-lg-6 my-1">
									<label for="nombreProv" class="form-label">Nombre:</label>
									<input required type="text" class="form-control" id="nombreProv" name="Nombre" placeholder="Los Almendros SA de CV">
								</div>
								<div class="col-lg-6 my-1">
									<label for="contact" class="form-label">Contacto:</label>
									<input required type="text" class="form-control" name="Contacto" id="contact" placeholder="Carlos Jim&eacute;nez">
								</div>
								<div class="col-lg-6 my-1">
									<label for="telef" class="form-label">Tel&eacute;fono:</label>
									<input required type="text" name="Telefono" class="form-control" id="telef" placeholder="(503)2352-7823">
								</div>
								<div class="col-lg-6 my-1">
									<label for="correo" class="form-label">Correo:</label>
									<input required type="text" name="Email" class="form-control" id="correo" placeholder="name@example.com">
								</div>
								<div class="col-lg-6 my-1">
									<label for="nit" class="form-label">NIT:</label>
									<input required type="text" name="Nit"  class="form-control" id="nit" placeholder="1234-123456-123-1">
								</div>
								<div class="col-lg-6 my-1">
									<label for="nrc" class="form-label">NRC:</label>
									<input required type="text" name="Nrc"  class="form-control" id="nrc" placeholder="123456-1">
								</div>
								<div class="col-lg-12 my-1">
									<label for="direccion" class="form-label">Direcci&oacute;n:</label>
									<textarea class="form-control" name="Direccion" id="direc" rows="3"></textarea>
								</div>
								<div class="col-lg-6 my-1">
									<label for="listadoMarcas" class="form-label">Seleccione Marcas</label>
									<select class="form-control" aria-label="Default select example" name="listaM" id="listadoMarcas">
									  
									</select>
								</div>
								<div class="col-lg-6 my-1">
									<center>
										<label for="" class="form-label">Agregar a la Tabla</label><br>
										<button type="button" onclick="addRow();" class="btn btn-success"><i class="fas fa-plus-square"></i></button>
									</center>
								</div>
								<div class="col-12 my-3 ">
									<div class="row justify-content-center">
										<div class="col-6">
											<table id="tablaMarcas" class="tabla-arreglo table table-sm table-striped table-hover text-center table-bordered table-success">
												<thead class="bg-primary">
													<tr>
														<th>Id</th>
														<th>Nombre</th>
														<th>Remover</th>
													</tr>
												</thead>
												<tbody>
													
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="alert bg-success col-12 oculto" id="result">
									<div class="row justify-content-center text-white text-center">
										<p id="texto"> 
											
										</p>
									</div>
								</div>
							</div>
							<center class="mt-2">
								<button onclick="ejecutar()" type="button" class="btn btn-primary">
									<span class="fas fa-paper-plane"></span>
									Registrar Proveedor
								</button>
							</center>
						</form>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" onclick="arregloTabla()">Filas</button>
					<button type="button" class="btn btn-danger" data-bs-dismiss="modal">
						<span class="fas fa-sign-out-alt"></span>
						Close
					</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal Marcas-->
	<div class="modal fade" id="modalMarcas" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-sm ">
			<div class="modal-content bodyModal bg-secondary">
				<div class="modal-header">
					<h5 class="modal-title text-white " id="exampleModalLabel">Proveedor</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="">
					<table id="tablaModal" class="table2 table table-striped text-white table-striped">
						<thead>
							
						</thead>
						<tbody>

						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger"
						data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>