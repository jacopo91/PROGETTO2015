<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>FORNITORI</title>
</head>
<body>
	<f:view>
		<h1>LISTA FORNITORI</h1>
		
			<table>
				<tr>
					<th>Nome</th>

				</tr>
				<c:forEach var="provider" items="#{productController.providers}">
					<tr><h:form>
						<td><h:commandLink
								action="#{providerController.findProvider}"
								value="#{provider.name}">
								<f:param name="id" value="#{provider.id}" />
							</h:commandLink></td>
						<c:if test="${currentProduct != null}">
							<td><h:commandButton value="Aggiungi"
									action="#{productController.addProvider}">
									<f:param name="idProvider" value="#{provider.id}" />
								</h:commandButton></td>
						</c:if>
					</h:form></tr>
				</c:forEach>
			</table>
			<h:form><c:choose>
				<c:when test="${currentProduct != null}">
					<div>
						<h:commandLink action="#{productController.findProduct}"
							value="Torna al prodotto">
							<f:param name="id" value="#{currentProduct.id}" />
						</h:commandLink>
					</div>
				</c:when>
				<c:otherwise>
					<div>
						<a href="newProvider.jsp">Inserisci
							nuovo fornitore</a>
					</div>
					<a href="administratorConfirmed.jsp">Torna
						alla home</a>
				</c:otherwise>
			</c:choose>
		</h:form>
	</f:view>
</body>
</html>