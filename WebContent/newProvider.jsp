<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Nuovo provider</title>
</head>
<body>

	<f:view>
		<h1>INSERISCI UN NUOVO FORNITORE</h1>
		<h:form>
			<div>
				Nome:
				<h:inputText value="#{providerController.name}" required="true"
					requiredMessage="Nome obbligatorio" id="name" />
				<h:message for="name" />
			</div>

			<div>
				Email:
				<h:inputText value="#{providerController.email}" required="true"
					requiredMessage="Email obbligatoria" id="email" />
				<h:message for="email" />
			</div>

			<div>
				Telefono:
				<h:inputText value="#{providerController.phoneNumber}"
					required="true" requiredMessage="Telefono obbligatorio"
					id="phoneNumber" />
				<h:message for="phoneNumber" />
			</div>

			<div>
				Indirizzo:
				<h:inputText value="#{providerController.street}" required="true"
					requiredMessage="Via obbligatoria" id="street" />
				<h:message for="street" />
			</div>
			<div>
				Citta':
				<h:inputText value="#{providerController.city}" required="true"
					requiredMessage="Citta' obbligatoria" id="city" />
				<h:message for="city" />
			</div>
			<div>
				Paese:
				<h:inputText value="#{providerController.country}" required="true"
					requiredMessage="Nazione obbligatoria" id="country" />
				<h:message for="country" />
			</div>

			<div>
				<h:commandButton value="Conferma inserimento"
					action="#{providerController.createProvider}" />
			</div>

		</h:form>
		<div>
			<h:commandLink action="#{productController.listProviders}"
				value="Torna alla lista dei fornitori">
			</h:commandLink>
		</div>
	</f:view>
</body>
</html>