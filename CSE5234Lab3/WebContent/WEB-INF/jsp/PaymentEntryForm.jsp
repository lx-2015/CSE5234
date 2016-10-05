<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/paymententryformstyle.css" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment Entry Form</title>
</head>
<script>
function inputFormatChecking() {
	var result = true;
	
	return result;
}
</script>
<body>
	<jsp:include page="header.jsp"/>
	<p>Please enter your payment method below</p>
	<form:form modelAttribute="paymentInfo" method="post" action="submitPayment" onsubmit="return inputFormatChecking()">
		<table>
			<tr>
				<td>Credit Card Number:</td>
				<td><form:input id="creditCardNumber" path="creditCardNumber" /></td>
			</tr>
			<tr>
				<td>Expiration Date:</td>
				<td><form:input id="expirationDate" path="expirationDate" /></td>
			</tr>
			<tr>	
				<td>CVV Code:</td>
				<td><form:input id="cvvCode" path="cvvCode" /></td>
			</tr>
			<tr>
				<td>Card Holder Name:</td>
				<td><form:input id="cardHolderName" path="cardHolderName" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Submit" />
				</td>
			</tr>
		</table>
	</form:form>
	<jsp:include page="footer.jsp"/>
</body>
</html>