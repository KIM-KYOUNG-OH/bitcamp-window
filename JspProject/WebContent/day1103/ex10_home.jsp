<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>한 요소당 여러개의 값을 넘겨야 하는 경우</h1>
<form action="ex10_action.jsp" method="post">
	<h4>좋아하는 색상을 모두 골라보세요</h4>
	<input type='checkbox' name='color' value='orange'>오렌지색
	<input type='checkbox' name='color' value='pink'>핑크색
	<input type='checkbox' name='color' value='#48d1cc'>민트색
	<input type='checkbox' name='color' value='#b0e0e6'>하늘색
	<br><br>
	<h4>공부중인 IT언어를 골라보세요</h4>
	<select name="itlang" multiple='multiple' size="7">
		<option value="Java">자바</option>
		<option value="HTML">HTML</option>
		<option value="Jquery">제이쿼리</option>
		<option value="Spring">스프링</option>
		<option value="React">리액트</option>
	</select>
	<br><br>
	<button type="submit">서버에 전송하기</button>
</form>
</body>
</html>