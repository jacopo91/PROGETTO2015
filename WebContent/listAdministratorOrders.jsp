<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>ORDINI</title>
</head>
<body>
	<f:view>
		<c:if test="${currentCustomer != null}">
			<h1>I MIEI ORDINI</h1>
		</c:if>
		<c:if test="${currentAdministrator != null}">
			<h1>ORDINI IN PRONTA EVASIONE</h1>
		</c:if>
		<table>
			<tr>
				<th>ID</th>
				<th>Data creazione</th>
				<th>Data chiusura</th>
				<th>Data evasione</th>
				<th>Stato</th>
				<c:if test="${currentAdministrator != null}">
					<th>Cliente</th>
				</c:if>
			</tr>
			<c:forEach var="order" items="#{orderController.orders}">
				<tr>
					<h:form>
						<td><h:commandLink action="#{orderController.findOrder}"
								value="#{order.id}">
								<f:param name="id" value="#{order.id}" />
							</h:commandLink></td>
					</h:form>
					<td>${order.creationTime}</td>
					<td>${order.closingTime}</td>
					<td>${order.evasionTime}</td>
					<td>${order.state}</td>
					<c:if test="${currentAdministrator != null}">
						<h:form>
							<td><h:commandLink
									action="#{customerController.findCustomer}"
									value="#{order.customer.email}">
									<f:param name="id" value="#{order.customer.id}" />
								</h:commandLink></td>
						</h:form>
						<h:form>
							<td><h:commandButton
									action="#{orderController.evasionOrder}" value="EVADI">
									<f:param name="id" value="#{order.id}" />
								</h:commandButton></td>
						</h:form>
					</c:if>
				</tr>
			</c:forEach>
		</table>
		<h:form>
			<c:if test="${currentCustomer != null}">
				<table>
					<tr>
						<td><h:commandButton action="#{orderController.createOrder}"
								value="Crea nuovo ordine" /></td>
					</tr>
				</table>

				<div>
					<a href="customerConfirmed.jsp">Torna
						alla home</a>
				</div>
			</c:if>
			<c:if test="${currentAdministrator != null}">
				<div>
					<a href="administratorConfirmed.jsp">Torna
						alla home</a>
				</div>
			</c:if>
		</h:form>
	</f:view>
</body>
</html>