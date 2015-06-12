<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>ELENCO CLIENTI</title>
</head>
<body>
	<f:view>
		<h1>Elenco clienti in anagrafica</h1>
		<h:form>
			<table>
				<tr>
					<th>Nome</th>
					<th>Cognome</th>
				</tr>
				<c:forEach var="customer" items="#{customerController.customers}">
					<tr>
						<td><h:commandLink
								action="#{customerController.getCustomerProfile}"
								value="#{customer.firstName}">
								<f:param name="id" value="#{customer.id}" />
							</h:commandLink></td>
						<td><h:commandLink
								action="#{customerController.getCustomerProfile}"
								value="#{customer.lastName}">
								<f:param name="id" value="#{customer.id}" />
							</h:commandLink></td>
					</tr>
				</c:forEach>
			</table>
			<div>
				<a href="administratorConfirmed.jsp">Torna alla home</a>
			</div>
		</h:form>
	</f:view>
</body>
</html>