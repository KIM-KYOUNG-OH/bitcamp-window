<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	boolean isLogin = false;
	//로그인 시 저장한 세션 얻기
	String loginok = (String)session.getAttribute("loginok");
	if(loginok!=null){
		isLogin = true;
	}
%>
<body>
<%
	if(isLogin){%>
		<jsp:include page="sessionlogout.jsp"/>
	<%}else{%>
		<jsp:include page="sessionlogin.jsp"/>
	<%}
%>
<hr align="left" width="500" size="10" color="orange">
<h1>오늘의 주요기사</h1>
<jsp:include page="paper.jsp"/>
</body>
</html>