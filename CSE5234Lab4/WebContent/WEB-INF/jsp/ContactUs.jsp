<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/contactusstyle.css" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>
</head>
<body>
	<br/>
	<jsp:include page="header.jsp"/>
	<h1>Contact Us</h1>
	<table>
		<tr>
			<th>Department</th>
			<th>Tel</th>
			<th>Email</th>
		</tr>
		<tr>
			<td>Customer Service</td>
			<td>614-123-4567</td>
			<td>customerservice.snackonline.com</td>
		</tr>
		<tr>
			<td>Technical Support</td>
			<td>614-456-7890</td>
			<td>technicalsupport.snackonline.com</td>
		</tr>
	</table>
</body>
</html>