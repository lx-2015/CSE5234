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
	<form:form modelAttribute="order" method="post" action="purchase/submitItems" onsubmit="return onSubmitChecking()">
		<table>
			<tr>
				<th>No.</th>
				<th>Name</th>
				<th>Price</th>
				<th>Quantity</th>
			</tr>
			<c:forEach items="${order.itemList}" var="item" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td><input name="itemList[${status.index}].name" value="${item.name}" /></td>
					<td><input name="itemList[${status.index}].price" value="${item.price}" /></td>
					<td><input id="quantity${status.count}" name="itemList[${status.index}].quantity" value="${item.quantity}" onchange="quantityFormatChecking(${status.count})"/></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="4">
					<input type="submit" value="Submit" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>