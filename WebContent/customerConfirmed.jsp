<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>AUTENTICATO</title>
</head>
<body>
	<f:view>
		<h1>Ciao ${currentCustomer.firstName} scegli tra le seguenti
			azioni:</h1>
		<div>
			<div>
				<h:form>
					<h:commandLink action="#{orderController.listOrders}"
						value="Gestisci ordini" />
				</h:form>
			</div>
			<h:form>
				<h:commandLink action="#{productController.listProducts}"
					value="Catalogo prodotti" />
			</h:form>
		</div>
		<div>
			<h:form>
				<h:commandLink action="#{customerController.logoutCustomer}"
					value="Logout" />
			</h:form>
		</div>
	</f:view>
</body>
</html>