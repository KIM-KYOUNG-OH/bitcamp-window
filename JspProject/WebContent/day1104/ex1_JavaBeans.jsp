<%@page import="object.test.TestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>자바 빈즈를 이용해서 dto에 데이터 넣기</h1>
<!-- 자바빈즈 선언 - dto 생성하던 코드와 같다 -->
<jsp:useBean id="dto" class="object.test.TestDto" scope="page"/>
<!-- dto에 데이터를 넣어보자 -->
<jsp:setProperty property="carName" value="소나타" name="dto"/>
<jsp:setProperty property="carColor" value="red" name="dto"/>
<jsp:setProperty property="carPrice" value="4500" name="dto"/>

<!-- dto의 데이터를 꺼내서 출력해보자 - getter 메서드 호출과 같다 -->
차이름: <jsp:getProperty property="carName" name="dto"/><br>
차색상: <jsp:getProperty property="carColor" name="dto"/><br>
차가격: <jsp:getProperty property="carPrice" name="dto"/><br>
<hr>
<h1>자바코드를 이용해서 dto에 데이터 넣기</h1>
<%
	TestDto dto2 = new TestDto();
	dto2.setCarName("그랜져");
	dto2.setCarColor("진주색");
	dto2.setCarPrice(4300);
%>
차이름: <%=dto2.getCarName() %><br>
차색상: <%=dto2.getCarColor() %><br>
차가격: <%=dto2.getCarPrice() %>
</body>
</html>