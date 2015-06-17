<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Catalogo prodotti</title>


</head>
<body>
<body>

	<f:view>
		<h1>Catalogo prodotti</h1>
		<h3>Clicca sui prodotti per aggiungerli all'ordine</h3>
		<h:form>
			<table>
				<tr>
					<th>Nome</th>
					<th>Prezzo</th>
					<th>Quantita</th>
				</tr>
				<c:forEach var="product" items="#{productController.products}">
					<tr>
						<td><h:commandLink action="#{productController.findOrderProduct}"
								value="#{product.name}">
								<f:param name="id" value="#{product.id}" />
							</h:commandLink></td>
						<td>${product.price}</td>
						<td>${product.quantity}</td>
				</c:forEach>
			</table>
			<a href="customerOrder.jsp">Torna all'ordine</a>
			<a href="customerConfirmed.jsp">Torna alla home</a>
		</h:form>

	</f:view>
</body>


</html>