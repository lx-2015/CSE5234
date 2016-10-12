<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/aboutusstyle.css" >
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About Us</title>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<h1>About Us</h1>
	<p>Our mission is to build the cheapest and best snack online retailer!!</p>
	<table>
		<tr>
			<th>Name</th>
			<th>Email</th>
			<th>Occupation</th>
			<th>Introduction</th>
		</tr>
		<tr>
			<td><img src="${pageContext.request.contextPath}/images/myphoto.jpg" 
				class="image"/><br />
				Xiang Li</td>
			<td >li.984@buckeyemail.osu.edu</td>
			<td>Co-founder, software developer</td>
			<td width= 450px>A second year Computer Science master student from the Ohio State University</td>
		</tr>
		<tr>
			<td>Senyang Hu</td>
			<td ></td>
			<td>Co-founder, software developer</td>
			<td width= 450px>A second year Computer Science master student from the Ohio State University</td>
		</tr>
		<tr>
			<td>Xiaojing Lin</td>
			<td ></td>
			<td>Co-founder, software developer</td>
			<td width= 450px>A second year Computer Science master student from the Ohio State University</td>
		</tr>
		<tr>
			<td>Shengjie Quan</td>
			<td ></td>
			<td>Co-founder, software developer</td>
			<td width= 450px>A senior undergraduate Computer Science student from the Ohio State University</td>
		</tr>
		
	</table>
</body>
</html>