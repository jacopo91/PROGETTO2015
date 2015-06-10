<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>CLIENTE</title>
</head>
<body>
	<f:view>
		<h1>BENVENUTO NELL'AREA CLIENTI</h1>
		<h:form>
			<h2>Inserisci i tuoi dati</h2>
			<div>
				Email:
				<h:inputText value="#{customerController.email}" required="true"
					requiredMessage="Email obbligatorio" id="email" />
				<h:message for="email" />
			</div>
			<div>
				Password:
				<h:inputSecret value="#{customerController.password}"
					required="true" requiredMessage="Password obbligatoria"
					id="password" />
				<h:message for="password" />
			</div>
			<div>
				<h:commandButton value="Accedi"
					action="#{customerController.loginCustomer}" />
			</div>
		</h:form>
		<div>
			<a href='<c:url value="faces/registrationCustomer.jsp" />'>Iscriviti
				se non l'hai ancora fatto!</a>
		</div>
		<div>
			<a href='<c:url value="faces/firstPage.jsp" />'>Torna alla home</a>
		</div>
	</f:view>
</body>