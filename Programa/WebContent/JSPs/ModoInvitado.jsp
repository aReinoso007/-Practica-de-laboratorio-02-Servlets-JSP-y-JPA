<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html">
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bienvenido</title>
<link rel="stylesheet"  href="/PracticaJPADAOWEB2/CONFIG/Style/styleLoggedOn.css" type="text/css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

<form action="/PracticaJPADAOWEB2/src/ec/ups/edu/controlador/controladorSesiones?id=3" method="GET">
<c:set var="t1" value="${requestScope['telefonos']}"/>

	
	<div class="header">
  		<h1>Lista de telefonos</h1>
	</div>
	<div class="topnav">
		<a href="/PracticaJPADAOWEB2/JSPs/Inicio.jsp">Home</a>
	</div>

	<table class="container">
	<thead>
		<tr>
			<th><h1>Cedula</h1></th>
			<th><h1>Numero</h1></th>
			<th><h1>Tipo</h1></th>
			<th><h1>Operadora</h1></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="telf" items="${t1}">
			<tr>
				<td>${telf.codigo}</td>
				<td>${telf.numero}<a href="tel: ${telf.numero }"><img width="25px"
							height="25px"
							src="https://img.icons8.com/ultraviolet/40/000000/phone.png" /></a></td>
				<td>${telf.tipo}</td>
				<td>${telf.operadora}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
</form>
</body>
</html>
