<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>HOME</title>
</head>
<body>
	<f:view>
		<h1>BENVENUTO</h1>
		<ul>
			<li><a href='<c:url value="/faces/loginCustomer.jsp" />'>Accesso
					clienti</a></li>
			<li><a href='<c:url value="/faces/loginAdministrator.jsp" />'>Accesso
					amministratori</a></li>
		</ul>
	</f:view>
</body>
</html>