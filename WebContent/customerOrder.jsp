<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Info ordine</title>

</head>
<body>
<body>
	<f:view>
		<h2>DETTAGLI DELL'ORDINE</h2>
		<div>ID ordine: ${currentOrder.id}</div>
		<div>
			Creato il:
			<h:outputText value="#{currentOrder.creationTime}">
				<f:convertDateTime dateStyle="medium" locale="it_IT" type="date" />
			</h:outputText>
		</div>

		<div>
			<c:choose>
				<c:when test="${currentOrder.chiuso == false}">Stato: Aperto</c:when>
				<c:otherwise>
		Stato: Completato
		</c:otherwise>
			</c:choose>
		</div>

		<c:if test="${currentOrder.completedTime != null }">
			<div>
				Data completamento:
				<h:outputText value="#{currentOrder.completedTime}">
					<f:convertDateTime dateStyle="medium" locale="it_IT" type="date" />
				</h:outputText>
			</div>
		</c:if>

		<div>
			<c:choose>
				<c:when test="${currentOrder.evaso == false}">Evaso: NO</c:when>
				<c:otherwise>
		Evaso: SI
		</c:otherwise>
			</c:choose>
		</div>

		<c:if test="${currentOrder.processedTime != null }">
			<div>
				Data evasione:
				<h:outputText value="#{currentOrder.processedTime}">
					<f:convertDateTime dateStyle="medium" locale="it_IT" type="date" />
				</h:outputText>
			</div>
		</c:if>

		<br>
		<h3>${orderController.message}</h3>

		<c:if test="${not empty currentOrder.orderLines}">
			<h4>Dettaglio:</h4>
			<h:form>
				<table>
					<tr>
						<th>Codice</th>
						<th>Nome</th>
						<th>Prezzo</th>
						<th>Quantità</th>
					</tr>

					<c:forEach var="orderLine" items="#{currentOrder.orderLines}">
						<tr>
							<td><h:commandLink
									action="#{productController.findOrderProduct}"
									value="#{orderLine.product.code}">
									<f:param name="id" value="#{orderLine.product.id}" />
								</h:commandLink></td>
							<td>${orderLine.product.name}</td>
							<td>${orderLine.unitPrice}</td>
							<td>${orderLine.quantity}</td>
						</tr>
					</c:forEach>
				</table>
			</h:form>
		</c:if>

		<c:if test="${currentOrder.chiuso == false}">

			<h:form>
				<h:commandLink
					action="#{productController.listCustomerOrderProducts}"
					value="metti nel carrello" />
			</h:form>
			<br>
			<h:form>
				<h:commandLink action="#{orderController.closeOrder}"
					value="Chiudi Ordine" />
			</h:form>
			<br>
		</c:if>

		<c:if
			test="${administratorController.currentAdministrator != null && currentOrder.chiuso == true && currentOrder.evaso == false}">
			<h:form>
				<h:commandLink action="#{orderController.processedOrder}"
					value="Evadi Ordine" />
			</h:form>

			<li><a href="administratorConfirmed.jsp"> Torna alla home</a></li>
		</c:if>
		<c:if test="${customerController.currentCustomer != null}">
			<a href="customerConfirmed.jsp"> Torna alla home</a>
		</c:if>
	</f:view>
</body>
</html>