<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>User Info</title>
	</head>
	<body>
		
		<jsp:include page="_menu.jsp"/>
	
		<h2>User Info Page</h2>
	 
	    <h3>Welcome :<c:out value="${pageContext.request.userPrincipal.name}"/></h3>
	 
	    <b>This is protected page!</b>  
	    
	</body>
</html> 