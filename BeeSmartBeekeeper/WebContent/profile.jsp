<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Моят профил</title>
<link rel="stylesheet" type="text/css" href="beeSmartBeekeeper_css.css">
<link rel="shortcut icon" type="image/x-icon" href="logo.png" />
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<div class="header">
 BeeSmartBeekeeper
</div>
<div class="row">
<div class="col-2 col-m-3 menu">
<ul>
<li onclick="parent.location='profile.jsp'">Моят профил</li>
<li onclick="location.href='https://thingspeak.com/channels/220932/';">Справка за кошер</li>
<li onclick="parent.location='changePassword.html'">Промени парола</li>
<li onclick="parent.location='CheckoutPage.jsp'">Изход</li>

</ul>
					

</div>
<div class="col-7 col-m-9">
<div id="box1">
       <div id="login">
<form class="contact_form" method="get" action="login"  >
    
    <%
//allow access only if session exists
String user = (String) session.getAttribute("user");
String userName = null;
String sessionID = null;
Cookie[] cookies = request.getCookies();
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("user")) userName = cookie.getValue();
	if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
}
}
%>
<h1 style="color:white;">Здравей, <%=userName %>.</h1>
<h3 style="color:white;">Провери своите пчелни семейства.</h3>
<br>
<div style="color:white;">
User: <%=user %>
</div>
<br>
<!--<a href="CheckoutPage.jsp">Checkout Page</a>
<form action="LogoutServlet" method="post">
<div>
<input type="submit" value="Logout" />
</div>
</form>-->
</form>
</div>
</div>
</div>

<div class="col-3 col-m-12">
……
</div>
</div>
<div class="footerholder">
<div class="footer">
BeeSmartBeekeeper | All rights reserved. 2016
</div>
</div>
</body>
</body>
</html>