<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<spring:url value="/resources/styles/cabecera.css" var="cabeceraCss" />
		<spring:url value="/resources/styles/body.css" var="bodyCss" />
		<link href="${cabeceraCss}" rel="stylesheet" />
		<link href="${bodyCss}" rel="stylesheet" />
		<spring:url value="/resources/images" var="images" />
		<spring:url value="/resources/styles/jQueryDatatable.css" var="jaqueryDatatableCss" />
		<link href="${jaqueryDatatableCss}" rel="stylesheet" />
		<spring:url value="/resources/js/jquery-1.12.3.js" var="jQuery" />
		<spring:url value="/resources/js/jQueryDatatables.js" var="jQueryDatable" />
		<script src="${jQuery}"></script>
		<script src="${jQueryDatable}"></script>
		<script type="text/javascript">
			$(document).ready(function() {
			    $("#botonDesplegable").click(function(){
			    	desplegarMenu();
			    });
			    $(".menuListado").click(function(){
			    	desplegarMenu();
			    });
			    var divLista = $('#desplegable');
			    var botonDes = $("#botonDesplegable");
			    $(document).bind('click',function(event){
			    	if(divLista.is(':visible') && event.target != divLista[0]
			    	 && event.target != botonDes[0]){
			    		$('#desplegable').hide();
			    	}
			    });
			    function desplegarMenu(){
			    	if(divLista.is(':visible')){
			    		$('#desplegable').hide();
			    	}else{
			    		$('#desplegable').show();
			    	}
			    }
			});
			function cambiarLabel(valor){
				document.getElementById('lblMenu').innerHTML= valor;
			}
		</script>
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
		<div id="posicionamiento">
			<div style="float:left;">
			<img src="${images}/caso.png" id="imgGeneralMenu" />
			</div>
			<div style="float:left;">
			<label id="lblMenu">Casos</label>
			</div>
		</div>
		<div id="desplegable">
			<div class="menuListado" onclick="javascript:cambiarLabel('Casos');">
				<img src="${images}/caso.png" id="imgCasoMenu" />
				<a href="#" >Casos</a>
			</div>
			<div class="menuListado" onclick="javascript:cambiarLabel('Contactos');">
				<a href="#">Contactos</a>
			</div>
			<div class="menuListado" onclick="javascript:cambiarLabel('Suministros');">
				<a href="#">Suministros</a>
			</div>
			<div class="menuListado" onclick="javascript:cambiarLabel('Direcciones');">
				<a href="#"  >Direcciones</a>
			</div>
			<div class="menuListado" onclick="javascript:cambiarLabel('Cuentas');">
				<a href="#" >Cuentas</a>
			</div>
		</div>
		<div id="divBotonDesplegable">			
			<input type="button" id="botonDesplegable" name="botonDesplegable" style="align:right;">
		</div>
		<div id="divTabs">
		&nbsp;
		</div>
	</div>
</body>
</html>