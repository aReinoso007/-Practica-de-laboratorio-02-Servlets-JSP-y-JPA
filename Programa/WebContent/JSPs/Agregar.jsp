<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar</title>
<link rel="stylesheet"  href="/PracticaJPADAOWEB2/CONFIG/Style/styleAdd.css" type="text/css">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<c:set var="p1" value="${ requestScope['usuario'] }" />
	<c:set var="p2" value="${ requestScope['idc'] }" />
</body>
<div class="header">
	<h1>Agregar numero</h1>

</div>
<div class="topnav">
	<a href="/PracticaJPADAOWEB2/JSPs/Inicio.jsp">Home</a> <a
		href="/PracticaJPADAOWEB2/controladorSesiones?id=2&ced=${p1.cedula}">Mi
		Cuenta</a> <a href=""></a> <a href="" style="float: right">Sing out</a>
</div>
<div class="info">

</div>
<div class="container">
	<form action="/PracticaJPADAOWEB2/AgregarNumero?ced=${p2 }" method="POST">

		<h1>Agregar telefono:</h1>
		
		<label for="numero" class="mb-2 mr-sm-2" >Numero: </label> 
		<input type="number" name="numero" placeholder="numero" maxlength="10"> 
		
		<label for="operadora" >Operadora: </label> 
		<input type="text" name="operadora" placeholder="operadora">
		
		 <label for="tipo">Tipo:</label>
		 <input type="text" name="tipo" placeholder="tipo">
		 
		<button type="submit" name="agregar" value="ingresar" class="btn btn-primary mb-2">ingresar</button>
	</form>
</div>
</html>