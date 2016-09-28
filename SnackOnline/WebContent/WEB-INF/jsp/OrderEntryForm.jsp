<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form modelAttribute="order" method="post" action="purchase/submitItems">
	<table>
		<tr>
			<th>No.</th>
			<th>Name</th>
			<td>Quantity</td>
		</tr>
		<c:forEach items="${order.itemList}" var="item" varStatus="status">
			<tr>
				<td align="center">${status.count}</td>
				<td><input name="itemList[${status.index}].name" value="${item.name}" /></td>
				<td><input name="itemList[${status.index}].quantity" value="${item.quantity}" /></td>
			</tr>
		</c:forEach>
		<tr>
			<td align="center" colspan="3">
				<input type="submit" value="Submit" />
			</td>
		</tr>
	</table>
</form:form>

</body>
</html>