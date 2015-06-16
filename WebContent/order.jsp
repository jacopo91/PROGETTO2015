<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>ORDINE</title>
</head>
<body>
	<f:view>
		<h1>Dettagli ordine</h1>
		<h:form>
			<table>
				<tr>
					<th>Prodotto</th>
					<th>Prezzo Unitario</th>
					<th>Quantità</th>
				</tr>
				<c:forEach var="orderLine" items="#{currentOrder.orderLines}">
					<tr>
						<td><h:commandLink action="#{productController.findProduct}"
								value="#{orderLine.product.name}">
								<f:param name="id" value="#{orderLine.product.id}" />
							</h:commandLink></td>
						<td>${orderLine.unitPrice}</td>
						<td>${orderLine.quantity}</td>
					</tr>
				</c:forEach>
			</table>
			<table>
				<tr>
					<td><h:commandButton value="Prosegui in seguito"
							action="#{orderController.fineInserimento}" /></td>
					<c:if test="${currentOrder.state == 'open'}">
						<td><h:commandButton value="Aggiungi prodotto"
								action="#{productController.listOrderProducts}" /></td>
						<td><h:commandButton value="Chiudi ordine"
								action="#{orderController.closeOrder}" /></td>
					</c:if>
				</tr>
			</table>
		</h:form>

	</f:view>
</body>
</html>