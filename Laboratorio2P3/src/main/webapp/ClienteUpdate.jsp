<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.laboratorio2p3.entidades.Login" %>

<!DOCTYPE html>
<html>

<head>



<meta charset="ISO-8859-1">

<title> Actualizar Cliente </title>
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
<link rel="stylesheet" type="text/css" href="styleUpdateCliente.css">
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
	String IdCliente = request.getParameter("IdCliente");
	String Cliente = request.getParameter("Cliente");
	String Tipo = request.getParameter("Tipo");
	String Contacto = request.getParameter("Contacto");
	String Telefono = request.getParameter("Telefono");
	String Direccion = request.getParameter("Direccion");
	String Correo = request.getParameter("Correo");
	String Dui = request.getParameter("Dui");
	String Nit = request.getParameter("Nit");
	String Nrc = request.getParameter("Nrc");
	

	if (IdCliente == null) {
	IdCliente = "";
	Cliente = "";
	Tipo = "";
	Contacto = "";
	Telefono = "";
	Direccion = "";
	Correo = "";
	Dui = "";
	Nit = "";
	Nrc = "";

}
%>
<body>
<section class="form-register">
	<form action="ControllerShowClientes" method="get">
					
					<div class="row">
					<input type="hidden" name="Id" id="id" value=<%=IdCliente%> disabled>
								<div class="col-lg-6 my-1">
									<label for="Nombre" class="form-label">Nombre:</label>
									<input type="text" class="form-control" required id="NombreCliente" name="Nombre" value=<%=Cliente%>>
								</div>
								<div class="col-lg-6 my-1">
									<label for="Tipo" class="form-label">Tipo:</label>
									<input type="text" class="form-control" name="Tipo" required id="Tipo"  value=<%=Tipo%>>
								</div>
								<div class="col-lg-6 my-1">
									<label for="Contacto" class="form-label">Contacto:</label>
									<input type="text" class="form-control" required name="Contacto" id="Contacto" value=<%=Contacto%>>
								</div>
								
								<div class="col-lg-6 my-1">
									<label for="telefono" class="form-label">Tel&eacute;fono:</label>
									<input type="text" name="Telefono" required class="form-control" id="telefono" value=<%=Telefono%>>
								</div>
								<div class="col-lg-12 my-1">
									<label for="Direccion" class="form-label">Direcci&oacute;n:</label>
									<textarea  class="form-control" name="Direccion" required id="Direccion" rows="3" value=<%=Direccion%>></textarea>
								</div>
								<div class="col-lg-6 my-1">
									<label for="Correo" class="form-label">Correo:</label>
									<input type="text" name="Correo" required class="form-control" id="Correo"  value=<%=Correo%>>
								</div>
								<div class="col-lg-6 my-1">
									<label for="Dui" class="form-label">Dui:</label>
									<input type="text" name="Dui" required class="form-control" id="Dui" value=<%=Dui%>>
								</div>
								<div class="col-lg-6 my-1">
									<label for="Nit" class="form-label">Nit:</label>
									<input type="text" name="Nit" required class="form-control" id="Nit" value=<%=Nit%>>
								</div>
								<div class="col-lg-6 my-1">
									<label for="Nrc" class="form-label">Nrc:</label>
									<input type="text" name="Nrc" required class="form-control" id="Nrc" value=<%=Nrc%>>
								</div>
								
							<center class="mt-2 odal-footer col text-center">
							
							<button type="submit"  name="Actualizar"  value="ACTUALI" class="btn btn-success"> 
							<span class="fas fa-badge-check"></span>
							Actualizar
						    </button>
							</center>	
							
					</form>
					
</section>
</body>
</html>