<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/confirmationstyle.css" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirmation</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<p id="congratulations">Congratulations! Your Order Is Placed!</p>
	<p id="confirmationCode">Your order confirmation code is: "${confirmationCode}"</p>
	<jsp:include page="footer.jsp" />
</body>
</html>