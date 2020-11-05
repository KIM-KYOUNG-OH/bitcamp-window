<%@page import="java.util.Vector"%>
<%@page import="object.test.TestDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	// 서블릿에서 request에 저장한 list가져오기
	List<TestDto> list = (Vector<TestDto>)request.getAttribute("list");
%>
<body>
<h2>서블릿에서 저장한 데이터 출력</h2>
<%
	for(TestDto dto: list){
	%>
		<div style="background-color:<%=dto.getCarColor() %>; width: 400px;">
			<pre>
				차이름: <%=dto.getCarName() %>
				차가격: <%=dto.getCarPrice() %>
				차색상: <%=dto.getCarColor() %>
			</pre>
		</div>
	<%}
%>
</body>
</html>