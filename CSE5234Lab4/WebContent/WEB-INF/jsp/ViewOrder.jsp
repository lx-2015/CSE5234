<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.osu.cse5234.controller.Order" %>
<%@ page import="edu.osu.cse5234.business.view.Item" %>
<%@ page import="edu.osu.cse5234.controller.PaymentInfo" %>
<%@ page import="edu.osu.cse5234.controller.ShippingInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/vieworderstyle.css" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Order</title>
</head>
<body>
	<% 
		response.getWriter().println("<br />Your Order Summary Is As Follows:<br /><br />");
		Order order = (Order)request.getSession().getAttribute("order");
		List<Item> itemList = order.getItemList();
		double totalAmount = 0;
		for (int i = 0; i < itemList.size(); i++) {
			Item item = itemList.get(i);
			if (Integer.parseInt(item.getQuantity()) > 0) {
			totalAmount += Double.parseDouble(item.getPrice()) * Integer.parseInt(item.getQuantity());
				response.getWriter().println("Item Name: " + item.getName() 
					+ ", Price Per Item: " + item.getPrice()
					+ ", Quantity: " + item.getQuantity() + "<br />");
			}
		}
		PaymentInfo paymentInfo = (PaymentInfo)request.getSession().getAttribute("paymentInfo");
		response.getWriter().println("<br />Your Payment Method Is As Follows:"
			+ "<br />Credit Card Number: " + paymentInfo.getCreditCardNumber()
			+ "<br />Expiration Date: " + paymentInfo.getExpirationDate()
			+ "<br />CVV Code: " + paymentInfo.getCvvCode()
			+ "<br />Card Holder Name: " + paymentInfo.getCardHolderName());
		ShippingInfo shippingInfo = (ShippingInfo)request.getSession().getAttribute("shippingInfo");
		response.getWriter().println("<br /><br />Your Shipping Address Is As Follows:"
			+ "<br />Name: " + shippingInfo.getName()
			+ "<br />Address Line 1: " + shippingInfo.getAddressLine1()
			+ "<br />Address Line 2: " + shippingInfo.getAddressLine2()
			+ "<br />City: " + shippingInfo.getCity()
			+ "<br />State: " + shippingInfo.getState()
			+ "<br />Country: " + shippingInfo.getZip());
		response.getWriter().println("<br/><br/> Your Total Is: $" + totalAmount + "<br />");
	%>
	<form:form modelAttribute="order" method="post" action="confirmOrder">
		<table>
			<tr>
				<td colspan="2">
					<input type="submit" value="Confirm" />
				</td>
			</tr>
		</table>
	</form:form>
	<jsp:include page="footer.jsp" />
</body>
</html>