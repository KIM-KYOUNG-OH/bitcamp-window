<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>이름:<%=name %></h2>
<h2>메서드로 이름 출력: <%=getName() %></h2>
<hr>
<%! 
	// 선언문이라 한다
	// 멤버변수나 메서드 정의
	// 서블릿으로 변환시 전역변수로 등록
	String name = "홍길동";
	// 메서드
	public String getName(){
		
		return name;
	}
%>
<%
	// scriptlet
	// 여기서 선언하는 변수는 지역변수로 등록이 되므로
	// 선언후 아랫쪽에서만 사용 가능
	String addr = "서울";
	// out 내장객체를 이용해서 출력
	out.print("<h3 style='color:red;'>"+name+"님의 주소는"+addr+"입니다</h3>");
%>
지역:<%=addr %>
<h3 style="color: green;"><%=name %>님의 주소는 <%=addr %>입니다</h3>
<!--  html주석 -->
<%-- jsp주석 --%>
<h2>html 주석 안에서 날짜 출력하기 -실행함- 소스보기에 보임</h2>
<!-- 
<%=new Date().toString()%>
 -->
 <h2>jsp 주석 안에서 날자 출력하기 -실행안함- 소스보기에도 안보임</h2>
 <%--
 <%=new Date().toString()%>
  --%>
</body>
</html>