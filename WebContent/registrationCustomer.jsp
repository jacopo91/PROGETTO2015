<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>NUOVO CLIENTE</title>
</head>
<body>
	<h1>REGISTRAZIONE CLIENTE</h1>
	<f:view>
		<h:form>
			<div>
				Nome:
				<h:inputText value="#{customerController.firstName}" required="true"
					requiredMessage="Nome obbligatorio" id="firstName" />
				<h:message for="firstName" />
			</div>
			<div>
				Cognome:
				<h:inputText value="#{customerController.lastName}" required="true"
					requiredMessage="Cognome obbligatorio" id="lastName" />
				<h:message for="lastName" />
			</div>
			<div>
				Email:
				<h:inputText value="#{customerController.email}" required="true"
					requiredMessage="Email obbligatoria" id="email" />
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
				Data di nascita:
				<h:inputText value="#{customerController.dateOfBirth}">
					<f:convertDateTime pattern="dd-mm-yyyy" />
				</h:inputText>

			</div>
			<div>
				Via:
				<h:inputText value="#{customerController.street}" required="true"
					requiredMessage="Via obbligatoria" id="street" />
				<h:message for="street" />
			</div>
			<div>
				Citta':
				<h:inputText value="#{customerController.city}" required="true"
					requiredMessage="Citta' obbligatoria" id="city" />
				<h:message for="city" />
			</div>
			<div>
				Paese:
				<h:inputText value="#{customerController.country}" required="true"
					requiredMessage="Nazione obbligatoria" id="country" />
				<h:message for="country" />
			</div>

			<div>
				<h:commandButton value="Conferma registrazione"
					action="#{customerController.createCustomer}" />
			</div>

		</h:form>
		<div>

			<a href="firstPage.jsp">Torna alla home</a>

		</div>
	</f:view>
</body>
</html>