<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>FORNITORE</title>
</head>
<body>
	<f:view>
		<h:form>
			<h1>${providerController.provider.name}</h1>
			<h2>Dettagli</h2>
			<div>
				<b>Email</b>: ${providerController.provider.email}
			</div>
			<div>
				<b>Indirizzo</b>: ${providerController.provider.address.street}
			</div>
			<div>
				<b>Citta'</b>: ${providerController.provider.address.city}
			</div>
			<div>
				<b>Stato</b>: ${providerController.provider.address.country}
			</div>


			<c:choose>
				<c:when test="${currentProduct != null}">
					<div>
						<h:commandLink action="#{productController.findProduct}"
							value="Torna al prodotto">
							<f:param name="id" value="#{currentProduct.id}" />
						</h:commandLink>
					</div>
				</c:when>
				<c:when test="${currentAdministrator != null}">
					<div>
						<h:commandLink action="#{productController.listProviders}"
							value="Torna alla lista dei fornitori">
						</h:commandLink>
					</div>
				</c:when>
				
			</c:choose>





		</h:form>
	</f:view>
</body>
</html>