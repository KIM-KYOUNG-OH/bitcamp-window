<%@page import="data.dao.ShopDao"%>
<%@page import="data.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
div.cart{
	float: right;
	cursor: pointer;
}

div.cart .carticon{
	font-size: 25px;
}

div.count{
	color: white;
	background-color: red;
	width: 20px;
	border: 1px solid gray;
	border-radius: 30px;
	text-align: center;
	font-weight: bold;
	position: relative;
	top: -40px;
	left: 15px;
}

</style>
<script type="text/javascript">
$(function(){
	$("div.cart").click(function(){
		location.href="index.jsp?main=shop/mycart.jsp";
	});
});
</script>
</head>
<%
	// 세션에서 id얻기
	String id = (String)session.getAttribute("myid");
	//dao 선언
	MemberDao dao = new MemberDao();
	// 아이디어에 해당하는 이름 얻기
	String name = dao.getName(id);
%>
	<body>
		<b><%=name %> 님</b>
		<div class="cart">
		<%
			ShopDao sdao = new ShopDao();
			// 카트 갯수 얻기
			int cartSize = sdao.getCartList(id).size();
		%>
			<span class="carticon glyphicon glyphicon-shopping-cart"></span>
			<div class="count"><%=cartSize%></div>
		</div>
		<br><br>
		<button type="button" class="btn btn-success"
		onclick="location.href='login/logoutaction.jsp'"
		style="margin-left: 30px; width: 100px;">로그아웃</button>
	</body>
</html>