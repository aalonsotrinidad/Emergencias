<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="cabecera.jsp"/> 

<html>
	<head>
		<script type="text/javascript">
			$(document).ready(function() {
			    $('#tablaCasos').DataTable();			    
			});
		</script>
	</head>
<body>
	<form name='formListadoCasos' action="listar" method='POST'>
		<div class="botoneraListado">
			<ul>
				<li><input type="submit" name="insertar" value="CrearCaso" /></li>
				<li><input type="submit" name="actualizar" value="Actualizar" /></li>
			</ul>
		</div>
		<div>
			<table id="tablaCasos" class="display" data-page-length="25" data-order="[[ 1, &quot;asc&quot; ]]">
				<thead>
		            <tr>
		            <!-- <th data-orderable="false"> -->
		                <th width="20%">Número de caso</th>
		                <th width="16%">Número de inservice</th>
		                <th width="16%">Canal origen</th>
		                <th width="16%">Estado</th>
		                <th width="16%">Subestado</th>
		                <th width="16%">Submotivo</th>
		            </tr>
	        	</thead>
	        	<tbody>
	        		<c:forEach items="${casos}" var="datosCaso">
						<tr>
							<td>${datosCaso.numeroCaso}</td>
							<td>${datosCaso.numeroInservice}</td>
							<td>${datosCaso.origen}</td>
							<td>${datosCaso.estado}</td>
							<td>${datosCaso.subEstado}</td>
							<td>${datosCaso.subMotivo}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</form>
</body>
</html>