<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>PRODOTTO</title>
</head>
<body>
	<f:view>
		<h1>${productController.product.name}</h1>
		<h2>Dettagli</h2>
		<div>Codice: ${productController.product.code}</div>
		<div>Prezzo: ${productController.product.price}</div>
		<div>Descrizione: ${productController.product.description}</div>
		<div>Lista Fornitori:</div>

		<c:forEach var="provider" items="#{productController.providers}">
			<h:form>
				<tr>
					<td><h:commandLink action="#{providerController.findProvider}"
							value="#{provider.name}">
							<f:param name="id" value="#{provider.id}" />
						</h:commandLink></td>
				</tr>
			</h:form>

		</c:forEach>
		<c:if test="${currentOrder != null}">
			<c:if test="${currentOrder.state == 'open'}">
				<h:form>
					<div>
						Quantità:
						<h:inputText value="#{orderController.quantity}"
							requiredMessage="Quantità obbligatoria"
							converterMessage="Quantità deve essere un numero" id="quantity" />
						<h:message for="quantity" />
						<h:commandButton value="Aggiungi"
							action="#{orderController.addOrderProduct}">
							<f:param name="idProduct" value="#{productController.product.id}" />
						</h:commandButton>
					</div>
				</h:form>
			</c:if>
			<h:form>
				<div>
					<h:commandLink value="Torna all'ordine"
						action="#{orderController.findOrder}">
						<f:param name="id" value="#{orderController.currentOrder.id}" />
					</h:commandLink>
				</div>
			</h:form>
		</c:if>


		<c:if test="${currentAdministrator != null}">

			<h:form>
				<div>
					<h:commandLink action="#{productController.listProviders}"
						value="Inserisci fornitori" />
				</div>
			</h:form>
			<h:form>
				<div>
					<a href="administratorConfirmed.jsp">Torna alla home</a>
				</div>
			</h:form>
		</c:if>
		<c:if test="${currentCustomer != null}">


			<h:form>
				<div>
					<a href="customerConfirmed.jsp">Torna alla home</a>
				</div>
			</h:form>
		</c:if>
				<h:form>
					<div>
						<a href="firstPage.jsp">Torna alla home</a>
					</div>
				</h:form>
	





	</f:view>
</body>
</html>