<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
	//form태그의 name들을 가져온다
	Enumeration<String> en = request.getParameterNames();
	while(en.hasMoreElements()) //다음 이름이 있으면 true, 없으면 false
	{
		//name을 가져온다
		String name = en.nextElement();
		//name에 해당하는 값을 가져온다
		String value = request.getParameter(name);
		//출력
		%>
		<h1><%=name %> : <%=value %></h1>
		<%
	}
%>
</body>
</html>