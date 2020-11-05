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
<%
	Date date = null;
%>
<body>
오늘 날짜: <%=date.toString()%>
<%
	request.setCharacterEncoding("utf-8");
	String name = request.getParameter("name");
	String hp1 = request.getParameter("hp1");
	String hp2 = request.getParameter("hp2");
	String hp3 = request.getParameter("hp3");
	String hp = hp1+"-"+hp2+"-"+hp3;
	String email1 = request.getParameter("email1");
	String email2 = request.getParameter("email2");
	String email = email1 +"@"+ email2;
	String gender = request.getParameter("gender");
%>
<table class="table table-striped" style="width: 400px;">
	<caption><h2>회원 정보 출력</h2></caption>
	<tr>
		<th bgcolor="pink" width="100">이름</th>
		<td><%=name %></td>
	</tr>
	<tr>
		<th bgcolor="pink" width="100">핸드폰</th>
		<td><%=hp %></td>
	</tr>
	<tr>
		<th bgcolor="pink" width="100">이메일</th>
		<td><%=email %></td>
	</tr>
	<tr>
		<th bgcolor="pink" width="100">성별</th>
		<td><%=gender %></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<button type="button" class="btn btn-info"
			onclick="location.href='ex14_form.jsp'">다시 입력 #1</button>
			
			<button type="button" class="btn btn-warning"
			onclick="history.back()">다시 입력 #2</button>
		</td>
		
	</tr>
</table>
</body>
</html>

























