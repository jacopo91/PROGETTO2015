<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<title>PROFILO CLIENTE</title>
</head>
<body>
	<f:view>
		<h1>${customerController.customer.firstName}
			${customerController.customer.lastName}</h1>
		<div>
			<b>Email</b>: ${customerController.customer.email}
		</div>
		<div>
			<b>Data di registrazione</b>:
			${customerController.customer.dateOfRegistration}
		</div>
		<div>
			<b>Data di nascita</b>: ${customerController.customer.dateOfBirth}
		</div>
		<div>
			<b>Indirizzo</b>: ${customerController.customer.address.street}
		</div>
		<div>
			<b>Citta'</b>: ${customerController.customer.address.city}
		</div>
		<div>
			<b>Stato</b>: ${customerController.customer.address.country}
		</div>
		<h:form>
			<h:commandLink action="#{customerController.findConfirmedCustomers}"
				value="Torna all'elenco clienti" />
		</h:form>
	</f:view>
</body>
</html>