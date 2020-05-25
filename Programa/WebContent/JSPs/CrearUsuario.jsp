<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar Usuario</title>
<link rel="stylesheet"  href="/Practica-1/CONFIG/Style/style.css" type="text/css">
</head>
<body>
	<form action="/Practica-1/CrearUsuario" method="POST">
	<div class="body"></div>
		<div class="grad"></div>
		<div class="header">
			<div><a href="/Practica-1/JSPs/Inicio.jsp" style="font-size:x-large">Agenda</a><span></span></div>
		</div>
		<br>
		<div class="login">
				<h1>Registrar Usuario</h1><br>
				<input type="text" placeholder="Nombre" name="nombre" required><br>
				<input type="text" placeholder="Apellido" name="apellido" required><br>
				<input type="text" placeholder="Cedula" name="cdi" required><br>
				<input type="text" placeholder="E-mail" name="email" required><br>
				<input type="password" placeholder="Password" name="password" required><br>
				<button type="submit" name="resp" value="Registrarse">Registrarse</button>
		</div>
</form>
</body>
</html>