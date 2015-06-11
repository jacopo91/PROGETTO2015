<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>NUOVO PRODOTTO</title>
</head>
<body>
	<h1>Inserisci nuovo prodotto</h1>
	<f:view>
		<h:form>
			<div>
				Nome:
				<h:inputText value="#{productController.name}" required="true"
					requiredMessage="Nome obbligatorio" id="name" />
				<h:message for="name" />
			</div>
			<div>
				Codice:
				<h:inputText value="#{productController.code}" required="true"
					requiredMessage="Codice obbligatorio" id="code" />
				<h:message for="code" />
			</div>
			<div>
				Prezzo:
				<h:inputText value="#{productController.price}" required="true"
					requiredMessage="Prezzo obbligatorio"
					converterMessage="Prezzo deve essere un numero" id="price" />
				<h:message for="price" />
			</div>
			<div>
				Descrizione:
				<h:inputTextarea value="#{productController.description}"
					required="false" cols="20" rows="5" />

			</div>
		</h:form>
		<h:form>
			<div>
				Quantita' Magazzino:
				<h:inputText value="#{productController.quantity}"
					requiredMessage="Quantita' obbligatoria"
					converterMessage="Quantita' deve essere un numero" id="quantity" />
				<h:message for="quantity" />
			</div>
			<div>
				<h:commandButton action="#{productController.createProduct}"
					value="Aggiungi" />
			</div>

			<div>
				<h:commandLink action="#{productController.listProducts}"
					value="Torna al catalogo" />
			</div>
		</h:form>

	</f:view>
</body>
</html>