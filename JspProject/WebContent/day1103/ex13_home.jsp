<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>오라클 테스트</h1>
<form action="ex13_action.jsp">
	<h3>다음중 DML명령어에 속하지 않는 SQL명령어는?</h3>
	<input type="radio" name='no1' value='1'>create
	<input type="radio" name='no1' value='2'>insert
	<input type="radio" name='no1' value='3'>delete
	<input type="radio" name='no1' value='4'>update
	<br><br>
	<h3>
	다음중 EMP 테이블에서 job의 종류중 중복되는 job은 제거하고<br>
	한번만 출력하기 위해서 괄호안에 들어가는 SQL명령어는(5점)?<br>
	select () job from emp;</h3>
	<input type="radio" name='no2' value='1'>group
	<input type="radio" name='no2' value='2'>distinct
	<input type="radio" name='no2' value='3'>unique
	<input type="radio" name='no2' value='4'>one
	<br><br>
	<h3>
	EMP테이블에서 평균 sal보다 연봉이 더 높은 사람의 name과 job을<br>
	출력하려고 한다. 다음중 알맞은 SQL명령어는(20점)?	
	</h3>
	<input type="radio" name='no3' value='1'>
		select name,job from emp sal>avg(sal)<br>
	<input type="radio" name='no3' value='2'>
		select name,job from emp sal>(select * from emp)<br>
	<input type="radio" name='no3' value='3'>
		select name,job from emp where sal>(select avg(sal) from emp)<br>
	<input type="radio" name='no3' value='4'>
		select name,job from emp sal>(select sum(sal) from emp)
	<br><br>
	<h3>	
	4. system계정에서 angel계정을 만든후 권한을 주려고 한다<br>
	괄호안에 들어가는 명령어로 올바른것은(70점)?<br>
	grant ( 1 ), ( 2 ) to angel;
	</h3>
	<input type="radio" name='no4' value='1'>create, update
	<input type="radio" name='no4' value='2'>add, add
	<input type="radio" name='no4' value='3'>connect, create
	<input type="radio" name='no4' value='4'>connect, resource
	<br><br>
	<b>작성자 : </b>
	<input type='text' name='name' size='6' required='required'>
	<br><br>
	<button type='submit' style='font-size: 1.5em; margin_left: 100px'>
	점수 알아보기</button>
</form>
</body>
</html>