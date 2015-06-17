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

		<c:if test="${currentOrder!=null && currentOrder.chiuso == false}">
			<p>
				<h:form>
					<div>
						Quantità:
						<h:inputText value="#{orderController.quantity}"
							requiredMessage="Quantità obbligatoria"
							converterMessage="Quantità deve essere un numero" id="quantity" />
						<h:message for="quantity" />
					</div>
					<h:commandLink id="addOrderLine"
						action="#{orderController.addOrderLine}"
						value=" Aggiungi al carrello">

					</h:commandLink>

				</h:form>
			<p>
		</c:if>
		<h:form>
			<div>
				<a href="order.jsp">Torna all'ordine</a>
			</div>
		</h:form>

		<c:if test="${currentCustomer != null}">

			<h:form>
				<div>
					<a href="customerConfirmed.jsp">Torna alla home</a>
				</div>
			</h:form>
		</c:if>

	</f:view>
</body>
</html>