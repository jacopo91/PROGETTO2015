<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Lista ordini</title>
 
  
</head>
<body>

	<f:view>
		<h1>Lista ordini </h1>
		<h:form>
			<table>
				<tr>
					<th>ID ordine</th>
					<th>Cliente</th>
					<th>Data creazione</th>
					<th>Stato</th>
					<th>Data completamento</th>
					<th>Evaso</th>
					<th>Data evasione</th>
					<th>Sospeso</th>

				</tr>
				<c:forEach var="order" items="#{administratorController.orders}">
					<tr>
						<td><h:commandLink action="#{orderController.findOrder}"
								value="#{order.id}">
								<f:param name="id" value="#{order.id}" />
							</h:commandLink></td>

						<td>${order.customer.email}</td>

						<td><h:outputText value="#{order.creationTime}">
								<f:convertDateTime dateStyle="medium" locale="it_IT" type="date" />
							</h:outputText></td>

						<td><c:choose>
								<c:when test="${order.chiuso == false}">Aperto</c:when>
								<c:otherwise>
								Completato
								</c:otherwise>
							</c:choose></td>

						<td><h:outputText value="#{order.completedTime}">
								<f:convertDateTime dateStyle="medium" locale="it_IT" type="date" />
							</h:outputText></td>

						<td><c:choose>
								<c:when test="${order.evaso == false}">NO</c:when>
								<c:otherwise>
							SI
							</c:otherwise>
							</c:choose></td>

						<td><h:outputText value="#{order.processedTime}">
								<f:convertDateTime dateStyle="medium" locale="it_IT" type="date" />
							</h:outputText></td>

						<td><c:choose>
								<c:when test="${order.sospeso == true && order.evaso == false}">SI</c:when>
								<c:otherwise>
							NO
							</c:otherwise>
							</c:choose></td>
				</c:forEach>
			</table>
		</h:form>
		<p></p>
					<a href="administratorConfirmed">Torna alla home</a>
	</f:view>
</body>
</html>