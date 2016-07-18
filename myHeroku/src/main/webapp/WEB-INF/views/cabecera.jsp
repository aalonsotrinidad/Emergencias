<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
	<head>
		<spring:url value="/resources/styles/cabecera.css" var="cabeceraCss" />
		<spring:url value="/resources/styles/body.css" var="bodyCss" />
		<link href="${cabeceraCss}" rel="stylesheet" />
		<link href="${bodyCss}" rel="stylesheet" />
		<spring:url value="/resources/images" var="images" />
	</head>
<body>
	<div id="cabeceraEnel">
		<div id="divImagenEnel">
			<img src="${images}/logo.png" id="logoEnel" />
		</div>
		<div id="divNoImagenEnel">
			<a href="#">Salir del sistema</a>
		</div>
	</div>
	<div id="menuCabecera">
		<ul id="navlist">
			<li><a href="location='homeCasos'">Casos</a></li>
			<li><a href="#">Contatos</a></li>
			<li><a href="#">Suministros</a></li>
			<li><a href="#">Direcciones</a></li>
		</ul>
	</div>
</body>
</html>