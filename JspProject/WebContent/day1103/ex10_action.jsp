<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div.box{
		width: 80px;
		height: 80px;
		margin-right: 10px;
		display: inline-block;
	}
</style>
</head>
<body>
<%
	// post방식일 경우 한글 엔코딩
	request.setCharacterEncoding("UTF-8");

	// 한 요소로 여러개 값을 넘겨받을 경우 getParameterValues
	// 선택을 안할경우 변수값은 null이 되고 있을 경우 배열로 넘어온다
	String []color = request.getParameterValues("color");
	String []itlang = request.getParameterValues("itlang");
%>
<h1>폼으로부터 전달받은 값 출력하기</h1>
<%
	if(color==null){%>
		<div>좋아하는 색깔이 없습니다
		</div>
	<%}else{
		for(String mycolor: color){%>
			<div class="box" style="background-color: <%=mycolor%>">
			</div>	
		<%}
		
	}
%>
<h1>현재 공부중인 IT언어</h1>
<%
	if(itlang == null){
		%>
		<h2>현재공부중인 언어가 없습니다</h2>
		<%
	}else{
		for(String it:itlang){
			%>
			<h2><%=it %></h2>
			<%
		}
	}
%>
</body>
</html>