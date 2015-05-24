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

		

		<c:if test="${currentAdministrator != null}">
			<h:form>
				<div>
					<h:commandLink action="#{productController.listProviders}"
						value="Inserisci fornitori" />
				</div>
			</h:form>
		</c:if>

		

	</f:view>
</body>
</html>