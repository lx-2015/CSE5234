<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/loginformstyle.css" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Form</title>
</head>
<body>
	<p>Please enter your information below</p>
	<form:form modelAttribute="order" method="post" action="purchase/submitLogin">
		<table>
			<tr>
				<td>Name</td>
				<td><form:input path="customerName" /></td>
			</tr>
			<tr>
				<td>Email Address</td>
				<td><form:input path="emailAddress" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Submit" />
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>