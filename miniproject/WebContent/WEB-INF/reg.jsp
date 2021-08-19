<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <br><%@ include file="welcome.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>register here</title>
</head>
<body>
<% if(request.getAttribute("save")==null){
	out.println("enter your useless data here");}
	%>
<form action ="B" method="post"><br>
First name<input type="text" name="fname"/><br>
city <input type="text" name="city"/><br>
mobile<input type="text" name="mobile"/><br>
<input type="submit" value="upload"/>
	
</form>
<% if(request.getAttribute("save")!=null){
	out.println(request.getAttribute("save"));}
	%>
</body>
</html>