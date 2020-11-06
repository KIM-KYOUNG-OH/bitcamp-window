<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div.mymenu{
		width: 100%;
		display: flex;
	}
	
	div.mymenu ul{
		list-style: none;
		margin: 0 auto;
	}
	
	div.mymenu ul li{
		float: left;
		width: 130px;
		height: 70px;
		line-height: 70px;
		border: 1px solid #db7093;
		margin-right: 20px;
		border-radius: 20px;
	}
	
	div.mymenu ul li:hover{
		background-color: #ffb6c1;
		color: #483d8b;
		cursor: pointer;
	}
	
	.bottom{
		border-bottom: 5px solid #333;
		border_right: 5px solid #333;
	}
</style>
<script type="text/javascript">
$(function(){
	if(localStorage.menu!=null){
		$("div.mymenu ul li").each(function(i,element){
			if(localStorage.menu == $(this).attr("menu")){
				$(this).addClass("bottom");
				$(this).next().click(); // 해당 메뉴의 a태그 이벤트 호출
			}
		});
	}else{
		$("div.mymenu ul li").eq(0).addClass("bottom");
	}
	
	$("div.mymenu ul li a").click(function(e){
		// 기본 이벤트 무효화
		e.preventDefault();
		// href값을 얻어서 해당 url로 이동
		var href=$(this).attr("href");
		location.href = href;
		var menu = $(this).parent().attr("class");
		localStorage.menu = menu;
	});
});
</script>
</head>
<body>
<%
	// 프로젝트의 경로 구하기
	String url = request.getContextPath();
%>
<div class='mymenu'>
	<ul>
		<li class="menu1">
			<a href="<%=url%>/index.jsp">Home</a>
		</li>
		<li class="menu2">
			<a href="<%=url%>/index.jsp?main=member/memberlist.jsp">회원목록</a>
		</li>
		<li class="menu3">
			<a href="<%=url%>/index.jsp?main=guest/guestlist.jsp">방명록</a>
		</li>
		<li class="menu4">
			<a href="<%=url%>/index.jsp?main=board/boardlist.jsp">게시판</a>
		</li>
	</ul>
</div>
</body>
</html>