<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html">
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bienvenido</title>
<link rel="stylesheet"  href="/Practica2/CONFIG/Style/styleLoggedOn.css" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<c:set var="t1" value="${requestScope['telefono']}"/>
<c:set var="p2" value="${requestScope['usuario'] }"/>

<%/* <h1>Login con exito</h1> */%>
	
	<div class="header">
		<div class="w3-display-topmiddle w3-container">
		<img src="https://www.pavilionweb.com/wp-content/uploads/2017/03/man-300x300.png" alt="John" style="width:100%">
  		<h1>Bienvenido</h1>
  		<h1> ${ p2.nombre } ${p2.apellido }</h1>
  			<ul>
  				<li><a href="/Practica2/controladorSesiones?id=2&idU=${p2.cedula }"></a>
  			</ul>
		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
	</div>
	<div class="topnav">
		<a href="/Practica2/JSPs/Inicio.jsp">Home</a>
		<a href="/Practica2/JSPs/Busquedas.jsp">Busqueda</a>
		<a href="/Practica2/controladorSesiones?id=1&c=${p2.cedula }">Agregar Numero</a>
		<a href="/Practica2/LogOut" style="float:right">Sing out</a>
	</div>
	
	
	<table class="container">
	<thead>
		<tr>
			<th><h1>Codigo</h1></th>
			<th><h1>Numero</h1></th>
			<th><h1>Tipo</h1></th>
			<th><h1>Operadora</h1></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="telf" items="${t1}">
			<tr>	
				<td>${telf.telf_id}</td>
				<td>${telf.numero}<a href="tel: ${telf.numero }"><img width="25px"
							height="25px"
							src="https://img.icons8.com/ultraviolet/40/000000/phone.png" /></a></td>
				<td>${telf.tipo}</td>
				<td>${telf.operadora}</td>
				<td><a href="/Practica2/EliminarNumero?id=${telf.telf_id}&idUser=${p2.cedula}">Eliminar</a></td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
</body>
</html>