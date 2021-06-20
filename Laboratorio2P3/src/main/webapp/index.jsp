<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
	<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css" integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous"/>
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div class="container">
	    <div class="row">
	        <div class="col-md-6">
	            <div class="card">
	                <form action="ControllerAcceso" method="post" class="box">
	                    <h1>AgenciaC</h1>
	                    <p class="text-muted"> Ingresa tus credenciales para Acceder!</p> 
	              		<input type="text" name="user" autocomplete="false" autofocus placeholder="Usuario"> 
	                    <input type="password" name="pass" placeholder="Contrase&ntilde;a"> 
	                    <input class="form-check-input" type="checkbox" name="tipo" id="ch">
						<label class="form-check-label text-white" for="ch">&nbsp;&nbsp;&nbsp;Admin</label>
						<br>
	                    <input type="submit" name="" value="Acceder" href="#">
	                </form>
	            </div>
	        </div>
	    </div>
	</div>
</body>
</html>