<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Anton&family=Black+Han+Sans&family=Jua&family=Yeon+Sung&display=swap" rel="stylesheet">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<style type="text/css">
	body {
       min-width: 650px;
	}
	
	a.home{
		color: black;
		text-decoration: none;
	}
	
	a.home:visited{
		color: black;
	}
	
	a.home:hover{
		color: gray;
		cursor: pointer;
		text-decoration: none;
	}
	
	div.layout div.title{
		height: 130px;
		line-height: 130px;
		font-size: 40px;
		text-align: center;
		font-family: 'Anton', sans-serif;
	}
	
	div.layout div.menu{
		text-align: center;
		font-size: 20px;
		font-family: 'Black Han Sans', sans-serif;
	}
	
	div.layout div.info{
		position: absolute;
		left: 20px;
		top: 480px;
		width: 200px;
		height: 200px;
		border: 2px solid gray;
		border-radius: 30px;
		font-size: 15px;
		padding: 20px;
		font-family: 'Yeon Sung', cursive;
	}
	
	div.layout div.login{
		position: absolute;
		left: 20px;
		top: 280px;
		width: 200px;
		height: 150px;
		border: 2px solid gray;
		border-radius: 30px;
		font-size: 15px;
		padding: 20px;
		font-family: 'Yeon Sung', cursive;
	}
	
	div.layout div.main{
		position: absolute;
		left: 300px;
		top: 280px;
		font-family: 'Jua', sans-serif;
		min-width: 500px;
		min-height: 555px;
	}
	
	div.mymenu ul li.bottom{
		border-bottom: 5px solid #333;
		border_right: 5px solid #333;
	}
</style>
<script type="text/javascript">
$(function(){
	$("div.mymenu ul li a").click(function(e){
		// 기본 이벤트 무효화
		e.preventDefault();
		$("div.mymenu ul li").removeClass("bottom");
		$(this).parent().addClass("bottom");
		//href 값을 얻어서 해당 url로 이동
		var href=$(this).attr("href");
		location.href=href;
	});
});
</script>
</head>
<%
	//메인페이지에 들어갈 파일 읽기
	String mainPage = "layout/main.jsp";
	if(request.getParameter("main")!=null){
		mainPage = request.getParameter("main");
	}
%>
<body>
<div class="layout">
	<div class="login">
		<jsp:include page="login/loginmain.jsp"/>
	</div>
	<div class="title">
		<jsp:include page="layout/title.jsp"/>
	</div>
	<div class="menu">
		<jsp:include page="layout/menu.jsp"/>
	</div>
	<div class="main">
		<jsp:include page="<%=mainPage %>"/>
	</div>
	<div class="info">
		<jsp:include page="layout/info.jsp"/>
	</div>
</div>
</body>
</html>