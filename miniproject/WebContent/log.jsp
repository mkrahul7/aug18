<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if(request.getAttribute("invalid")!=null){
	out.println(request.getAttribute("invalid"));}
	%>

<form action="A" method="post">name<input type="text" name="name"/><br>
password<input type="text" name="pw"/><br>
<input type="submit" value="login"/>

</form>

</body>
</html>