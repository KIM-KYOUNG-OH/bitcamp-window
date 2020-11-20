<%@page import="data.dao.BoardDao"%>
<%@page import="data.dto.BoardDto"%>
<%@page import="data.dto.ShopDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Refresh" content="10;url=index.jsp?">
<title>Insert title here</title>
<style type="text/css">
	div.main_sangpumlist{
		position: absolute;
		left: 0px;
		top: 0px;
		height: 250px;
		width: 400px;
		border: 10px solid pink;
		border-radius: 30px;
	}
	
	div.main_sangpumlist span.mainshop{
		cursor: pointer;
		float: right;
		font-size: 1.5em;
	}
	
	div.main_sangpumlist b{
		height: 30px;
		line-height: 30px;
		margin-left: 5px;
	}
	
	div.main_boardlist{
		position:absolute;
		left: 500px;
		top: 0px;
		height: 250px;
		width: 400px;
		border: 10px solid pink;
		border-radius: 30px;
	}
	
	div.main_boardlist span.mainboard{
		cursor: pointer;
		float: right;
		font-size: 1.5em;
	}
</style>
<script type="text/javascript">
$(function(){
	$("span.mainshop").click(function(){
		location.href="index.jsp?main=shop/shoplist.jsp";
	});
	
	$("span.mainboard").click(function(){
		location.href="index.jsp?main=board/boardlist.jsp";
	});
});
</script>
</head>
<body>
<div class="main_sangpumlist">
	<b>상품 목록 게시판</b>
	<span class="mainshop glyphicon glyphicon-plus-sign"></span>
	<%
	//최신글 4개 가져오기
	ShopDao sdao = new ShopDao();
	List<ShopDto> list = sdao.getNewSangpums();
	%>
	<table class="table table-bordered">
		<%
		int i=0;
		for(int col=1;col<=2;col++){
			%>
			<tr>
			<%for(int row=1;row<=2;row++){
				ShopDto dto = list.get(i++);
				String photo = dto.getPhoto().split(",")[0];
				%>
				<td align="center">
					<a href="index.jsp?main=shop/detailpage.jsp?shopnum=<%=dto.getShopnum() %>">
						<img alt="" src="shopsave/<%=photo%>"
						style="width: 80px;height: 80px;">
					</a>
				</td>
			<%}%>
			<tr>
		<%}
		%>
	</table>
</div>
<div class="main_boardlist">
	<b>답변형 게시판</b>
	<span class="mainboard glyphicon glyphicon-plus-sign"></span>
	<%
	//최신글 4개 가져오기
	BoardDao bdao = new BoardDao();
	List<BoardDto> blist = bdao.getNewList();
	%>
	<table class="table table-bordered" style="font-size: 0.8em;">
		<tr bgcolor="#e6e6fa">
			<th width="270">제목</th>
			<th>작성자</th>
		</tr>
		<%
		for(BoardDto dto:blist){
			%>
			<tr>
				<td>
					<a href="index.jsp?main=board/content.jsp?num=<%=dto.getNum()%>&pageNum=1&key=a">
						<%=dto.getSubject() %></a>
				</td>
				<td><%=dto.getWriter() %></td>
			</tr>
			<%
		}
		%>
	</table>
</div>
</body>
</html>




















