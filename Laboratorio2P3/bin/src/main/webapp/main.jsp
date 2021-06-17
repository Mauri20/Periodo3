<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.laboratorio2p3.entidades.Login" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Main</title>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<table class="table1 table table-striped table-dark table-hover">
					<thead>
						<tr>
							<th colspan="4">
								Opciones del Menu
							</th>
						</tr>
					</thead>
					<tbody>
					<%
	  					//Retomando sesion
	  					HttpSession sesion = (HttpSession) request.getSession();
						Login log= (Login) sesion.getAttribute("log");
	  					
	  					//System.out.print( "Nombre usuario: "+log.getUser()+" ");
	  					
	  					if(log==null){
	  						response.sendRedirect("index.jsp");
	  					}else if(log.getTipo().equals("2")){
	  				%>
						<tr>
							<td colspan="2"><a href="ControllerClientes?action=go" class="btn btn-info"><i class="fas fa-child fa-3x m-1"></i><br>Clientes</a></td>
							<td colspan="2"><a href="ControllerVentas?action=go" class="btn btn-info"><i class="fas fa-concierge-bell fa-3x m-1"></i><br>Ventas</a></td>
						</tr>
						
					<%
  					}else{
					%>
						<tr>
							<td colspan="2"><a href="ControllerClientes?action=go" class="btn btn-info"><i class="fas fa-users fa-3x m-1"></i><br>Clientes</a></td>
							<td colspan="2"><a href="ControllerVentas?action=go" class="btn btn-info"><i class="fas fa-shopping-cart fa-3x m-1"></i><br>Ventas</a></td>
						</tr>
						<tr>
							<td><a href="ControllerUsuarios?action=go" class="btn btn-success"><i class="fas fa-user-circle fa-3x m-1"></i><br>Usuarios</a></td>
							<td><a href="ControllerEmpleados?action=go" class="btn btn-success"><i class="fas fa-briefcase fa-3x m-1"></i><br>Empleados</a></td>
							<td><a href="ControllerProveedores?action=go" class="btn btn-success"><i class="fas fa-truck fa-3x m-1"></i><br>Proveedores</a></td>
							<td><a href="ControllerCompras?action=go" class="btn btn-success"><i class="fas fa-money-check-alt fa-3x m-1"></i><br>Compras</a></td>
						</tr>
					<%
  					}
					%>
						<tr>
							<td colspan="4">
								<form action="ControllerAcceso" method="post">
				  					<button type="submit" name="btncerrar" class="btn btn-danger"><i class="fas fa-sign-out-alt m-1"></i>Salir</button>
				  				</form>
							</td>
						</tr>
					</tbody>
					&nbsp;
				</table>
			</div>
		</div>
	</div>
	
</body>
</html>