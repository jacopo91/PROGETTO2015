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


		<h1>ORDINI IN PRONTA EVASIONE</h1>
		<table>
			<tr>
				<th>ID</th>
				<th>Data creazione</th>
				<th>Data chiusura</th>
				<th>Data evasione</th>
				
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
					<td>${order.completedTime}</td>
					<td>${order.processedTime}</td>
					
						<h:form>
							<td><h:commandButton
									action="#{orderController.processedOrder}" value="EVADI">
									<f:param name="id" value="#{order.id}" />
								</h:commandButton></td>
						</h:form>
				</tr>
			</c:forEach>
		</table>
		<h:form>
			
			
				<div>
					<a href="administratorConfirmed.jsp">Torna alla home</a>
				</div>
		</h:form>
	</f:view>
</body>
</html>