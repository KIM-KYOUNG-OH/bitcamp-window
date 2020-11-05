<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
</head>
<body>
<%
	request.setCharacterEncoding("utf-8");
%>
<!-- Dto 선언 -->
<jsp:useBean id="dto" class="object.test.InfoDto"/>
<!-- 멤버와 이름이 같은 데이터 자동으로 넣어주기 -->
<jsp:setProperty property="*" name="dto"/>
<h1>읽은 데이터 확인하기</h1>
이름 : <%=dto.getName() %><br>
핸드폰 : <%=dto.getHp1() %>-<%=dto.getHp2() %>-<%=dto.getHp3() %><br>
이메일 : <%=dto.getEmail1() %>@<%=dto.getEmail2() %><br>
성별 : <%=dto.getGender() %>
</body>
</html>

























