<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>AUTENTICATO</title>
</head>
<body>
	<f:view>
		<h1>Ciao ${currentAdministrator.firstName} scegli tra le seguenti
			azioni:</h1>
		<ul>
			<h:form>
				<li><h:commandLink
						action="#{customerController.findSuspendedCustomers}"
						value="Gestione Clienti in Sospeso" /></li>
				<li><h:commandLink
						action="#{customerController.findConfirmedCustomers}"
						value="Elenco Clienti" /></li>
				<li><h:commandLink action="#{productController.listProducts}"
						value="Gestione Prodotti" /></li>
				<li><h:commandLink action="#{productController.listProviders}"
						value="Gestione Fornitori" /></li>
				<li><h:commandLink action="#{administratorController.listClosedOrders}"
						value="Gestione Ordini" /></li>
				
				<li><h:commandLink
						action="#{administratorController.logoutAdministrator}"
						value="Logout" /></li>
			</h:form>
		</ul>
	</f:view>
</body>
</html>