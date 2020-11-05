<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	
	String msg1 = request.getParameter("msg1");
	String msg2 = request.getParameter("msg2");
	String myimg = request.getParameter("myimg");
%>
<body>
<h3>전달받은 값은?</h3>
<h4>
	메세지1: <%=msg1 %><br>
	메세지2: <%=msg2 %><br>
	이미지명: <%=myimg %>
	<img src="<%=myimg %>" style="width: 200px;">
</h4>
</body>
</html>