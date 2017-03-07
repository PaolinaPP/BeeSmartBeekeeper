<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="beeSmartBeekeeper_css.css">
<link rel="shortcut icon" type="image/x-icon" href="logo.png" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login Success Page</title>
</head>
<body>
<div id="box1">
       <div id="login">
<%
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
}
}
%>
<h3 style="color:white;">Здравей, <%=userName %>!</h3>
 <h3 style="color:white;">Желаеш ли да излезнеш от своя профил?</h3>
<br>
<form action="LogoutServlet" method="post">
<input type="submit" value="Изход" class="submit_button" >
</form>
</div>
</div>
</body>
</html>