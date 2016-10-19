<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/orderentryformstyle.css" >
<script type="text/javascript" src="${pageContext.request.contextPath}/js/inputFormatChecking.js" ></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Entry Form</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<p>Please choose your favorite snacks below</p>
	<c:if test="${not empty valid && !valid}">
	<p id="errorMessage">Error! Please resubmit item quantities!</p>
	</c:if>
	<form:form modelAttribute="order" method="post" action="submitItems" onsubmit="return onSubmitChecking()">
		<table>
			<tr>
				<th>No.</th>
				<th>Item No.</th>
				<th>Name</th>
				<th>Description</th>
				<th>Price</th>
				<th>Select</th>
				<th>Quantity</th>
			</tr>
			<c:forEach items="${order.lineItemList}" var="lineItem" varStatus="status">
				<tr>
					<td>${status.count}</td> 
					<td>${lineItem.itemNumber}<input type="hidden" name="lineItemList[${status.index}].itemNumber" value="${lineItem.itemNumber}" /></td>
					<td>${lineItem.name}<input type="hidden" name="lineItemList[${status.index}].name" value="${lineItem.name}" /></td>
					<td>${lineItem.description}<input type="hidden" name="lineItemList[${status.index}].description" value="${lineItem.description}" /></td>
					<td>${lineItem.price}<input type="hidden" name="lineItemList[${status.index}].price" value="${lineItem.price}" /></td>
					<td><input type="checkbox" name="lineItemList[${status.index}].selected" value=true /></td>
					<td><input id="quantity${status.count}" name="lineItemList[${status.index}].quantity" value="${lineItem.quantity}" onchange="quantityFormatChecking(${status.count})" /></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="7">
					<input type="submit" value="Submit" />
				</td>
			</tr>
		</table>
	</form:form>
	<jsp:include page="footer.jsp"/>
</body>
</html>