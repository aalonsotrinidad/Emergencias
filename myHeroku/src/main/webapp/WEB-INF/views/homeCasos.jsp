<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="cabecera.jsp"/> 

<html>
	<head>
		<spring:url value="/resources/styles/jQueryDatatable.css" var="jaqueryDatatableCss" />
		<link href="${jaqueryDatatableCss}" rel="stylesheet" />
		<spring:url value="/resources/js/jquery-1.12.3.js" var="jQuery" />
		<spring:url value="/resources/js/jQueryDatatables.js" var="jQueryDatable" />
		<script src="${jQuery}"></script>
		<script src="${jQueryDatable}"></script>
		<script type="text/javascript">
			$(document).ready(function() {
			    $('#tablaCasos').DataTable();
			});
		</script>
	</head>
<body>
	<!--<form name='formListadoCasos' action="listar" method='POST' >-->
	<form:form method="POST" commandname="formListadoCasos" action="listar">
	Casos
		<table id="tablaCasos" class="display" width="100%" data-page-length="25" data-order="[[ 1, &quot;asc&quot; ]]">
			<thead>
	            <tr>
	                <th>Número de caso</th>
	                <th data-orderable="false">Estado</th>
	            </tr>
        	</thead>
        	<tbody>
        		<c:forEach items="${casos}" var="datosCaso">
					<tr>
						<td>${datosCaso.numeroCaso}</td>
						<td>${datosCaso.estado}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<input type="submit" name="insertar" value="Insertar" />
		<input type="submit" name="actualizar" value="Actualizar" />
		
		<form:select path="phone" items="${statusMap}"> </form:select>
	</form:form>
	<!--</form>-->
</body>
</html>