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
	//request의 메세지 읽기
	String message = (String)request.getAttribute("message");
%>
<h1>Ex7번에서 ex8번으로 리다이렉트</h1>
<h2>
	메세지 출력: <%=message %>
	<br>
	<pre>
	널값이 나오는 이유는 리다이렉트는 request가 새로 생성되므로
	당연히 request에 저장된 값을 읽을수 없다
	</pre>
</h2>
<hr>
<h1>get방식으로 보낸 데이터 읽기</h1>
<%
	String sangpum=request.getParameter("sangpum");
	String price = request.getParameter("price");
%>
<h2>
	<pre>
		상품명 : <%=sangpum %>
		가격 : <%=price %>
	</pre>
</h2>
</body>
</html>