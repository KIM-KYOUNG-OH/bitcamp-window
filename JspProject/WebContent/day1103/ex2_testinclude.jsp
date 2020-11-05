<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div.layout div{
		position: absolute;
	}
	
	div.layout .top{
		font-size: 30px;
		text-align: center;
		height: 100px;
		line-height: 100px;
		left:0;
		top: 10px;
		width: 100%;
		background-color: #ffdd33; 
	}
	
	div.layout .menu{
		font-size: 25px;
		height: 500px;
		line-height: 30px;
		left:20;
		top: 150px;
		width: 200px;
		text-align: left;
		background-color: #ffddff; 
	}
	
	div.layout .main{
		font-size: 25px;
		height: 500px;
		left: 350px;
		top: 150px;
		width: 200px;
		text-align: left;
	}
	
	div.layout .info{
		font-size: 20px;
		width: 160px;
		height: 100px;
		left: 80%;
		top: 250px;
		border: 2px solid gray;
		border-radius: 40px;
		background-color: orange;
		color: blue;
		text-align: left;
	}
</style>
</head>
<body>
<div class="layout">
	<div class='top'>
		<jsp:include page="top.jsp"></jsp:include>
	</div>
	<div class='menu'>
		<jsp:include page="menu.jsp"></jsp:include>
	</div>
	<div class='info'>
		<jsp:include page="info.jsp"></jsp:include>
	</div>
	<div class='main'>
		<jsp:include page="main.jsp"></jsp:include>
	</div>
</div>
</body>
</html>