<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>CATALOGO PRODOTTI</title>
</head>
<body>
	<f:view>
		<h1>Catalogo prodotti</h1>

		<table>
			<tr>
				<th>Nome</th>
				<th>Codice</th>
				<th>Prezzo</th>
				<th>Quantita Magazzino</th>
			</tr>

			<c:forEach var="product" items="#{productController.products}">
				<h:form>
					<tr>
						<td><h:commandLink action="#{productController.findProduct}"
								value="#{product.name}">
								<f:param name="id" value="#{product.id}" />
							</h:commandLink></td>
						<td>${product.code}</td>
						<td>${product.price}</td>
						<td>${product.quantity}</td>
						<c:if test="${currentAdministrator != null}">
							<td>Quantita da aggiungere: <h:inputText
									value="#{productController.quantity}"
									requiredMessage="Quantità obbligatoria"
									converterMessage="Quantità deve essere un numero" id="quantity" />
								<h:message for="quantity" /> <h:commandButton value="Aggiungi"
									action="#{productController.updateProductQuantity}">
									<f:param name="id" value="#{product.id}" />
								</h:commandButton></td>
						</c:if>
					</tr>
				</h:form>
			</c:forEach>
		</table>
		<c:choose>
			<c:when test="${currentAdministrator != null}">
				<div>
					<a href="newProduct.jsp">Inserisci
						nuovo prodotto</a>
				</div>
				<div>
					<a href="administratorConfirmed.jsp">Torna
						alla home</a>
				</div>
			</c:when>
			<c:when test="${currentOrder != null}">
				<div>
					<a href="order.jsp">Torna ai dettagli
						dell'ordine</a>
				</div>
			</c:when>

			<c:when test="${currentCustomer != null }">
				<div>
					<a href="customerConfirmed.jsp">Torna
						alla home</a>
				</div>
			</c:when>
			<c:otherwise>
				<div>
					<a href="firstPage.jsp">Torna alla
						home</a>
				</div>


			</c:otherwise>
		</c:choose>
	</f:view>
</body>
</html>