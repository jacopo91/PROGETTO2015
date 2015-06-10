<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>AMMINISTRATORE</title>
</head>
<body>
	<f:view>
		<h1>Inserisci i tuoi dati</h1>
		<h:form>
			<div>
				Username:
				<h:inputText value="#{administratorController.username}"
					required="true" requiredMessage="Username is mandatory"
					id="username" />
				<h:message for="username" />
			</div>
			<div>
				Password:
				<h:inputSecret value="#{administratorController.password}"
					required="true" requiredMessage="Password is mandatory"
					id="password" />
				<h:message for="password" />
			</div>
			<div>
				<h:commandButton value="Accedi"
					action="#{administratorController.loginAdministrator}" />
			</div>
		</h:form>
		<div>
			<a href="firstPage.jsp">Torna alla home</a>
		</div>
	</f:view>
</body>