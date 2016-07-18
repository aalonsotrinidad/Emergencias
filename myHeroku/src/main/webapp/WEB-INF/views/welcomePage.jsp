<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page session="false"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>${title}</title>
	</head>
	<body>
		<div style="border: 1px solid #ccc;padding:5px;margin-bottom:20px;">
		  <a href="/welcome">Home</a>
		  <a href="/userInfo">User Info</a>
		  <a href='/admin'>Admin</a>
		</div>
		<h1>Message : ${message}</h1>
	</body>
</html>