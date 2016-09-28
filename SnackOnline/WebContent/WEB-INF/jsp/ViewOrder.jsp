<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ page import="java.util.List" %>
<%@ page import="edu.osu.cse5234.controller.Order" %>
<%@ page import="edu.osu.cse5234.controller.Item" %>
<%@ page import="edu.osu.cse5234.controller.PaymentInfo" %>
<%@ page import="edu.osu.cse5234.controller.ShippingInfo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
	response.getWriter().println("Your Order Summary Is As Follows:<br />");
	Order order = (Order)request.getSession().getAttribute("order");
	List<Item> itemList = order.getItemList();
	for (int i = 0; i < itemList.size(); i++) {
		Item item = itemList.get(i);
		if (Integer.parseInt(item.getQuantity()) > 0) {
			response.getWriter().println("Item Name: " + item.getName() + " Quantity: " + item.getQuantity() + "<br />");
		}
	}
	PaymentInfo paymentInfo = (PaymentInfo)request.getSession().getAttribute("paymentInfo");
	response.getWriter().println("<br /><br />Your Payment Method Is As Follows:"
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
		+ "<br />Country" + shippingInfo.getZip());
%>

<form:form modelAttribute="order" method="post" action="confirmOrder">
	<table>
		<tr>
			<td colspan="2">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="Confirm The Order">
			</td>
		</tr>
	</table>
</form:form>
	
</body>
</html>