<%@page import="data.dto.ShopDto"%>
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
	img.large{
		width: 490px;
		height: 590px;
	}
	
	img.small{
		cursor: pointer;
		width: 80px;
		height: 90px;
		border: 1px solid gray;
		margin-right: 5px;
	}
	
	img.select{
		border: 4px solid magenta;
		border-radius: 20px;
	}
	
	div.colors{
		float: right;
  		width: 30px;
  		height: 30px;
  		border: 1px solid black;
  		margin-right: 5px;
  		cursor: pointer;
  	}
	
	div.mycolor{
		width: 50px;
		height: 50px;
		border: 1px solid black;
		margin-left: 100px;
	}
</style>
<script type="text/javascript">
$(function(){
	$("img.small").first().addClass("select");
	
	$("img.small").click(function(){
		$(this).siblings().removeClass("select");
		var imgsrc = $(this).attr("src");
		$("img.large").attr("src",imgsrc);
		$(this).addClass("select");
	});
	
	// 색상 클릭시 이벤트
	$("div.colors").click(function(){
		var mycolor = $(this).css("background-color");
		$("div.mycolor").css("background-color",mycolor);
		// hidden에 값 넣어준다
		$("#mycolor").val(mycolor);
	});
	
});
</script>
</head>
<%
	String shopnum = request.getParameter("shopnum");
	// 로그인 상태
	String loginok = (String)session.getAttribute("loginok");
	// 로그인한 아이디
	String myid = (String)session.getAttribute("myid");
	// 아이디에 해당하는 멤버 테이블의 시퀀스 번호
	MemberDao mdao = new MemberDao();
	String num = mdao.getNum(myid);
	
	// 해당 상품에 대한 데이터 가져오기
	ShopDao sdao = new ShopDao();
	ShopDto dto = sdao.getData(shopnum);
	// 사진들 배열타입으로 얻기
	String []photo = dto.getPhoto().split(",");
	// 색상들 배열타입으로 얻기
	String []color = dto.getColor().split(":");
%>
<body>
<form id="frm">
	<!-- hidden : 장바구니 db에 넣어야할 값들 -->
	<input type="hidden" name="shopnum" value="<%=shopnum%>">
	<input type="hidden" name="num" value="<%=num%>">
	<input type="hidden" name="mycolor" id="mycolor" value="<%=color[color.length-1]%>">
	<table style="width: 1000px;">
		<tr>
			<td style="width: 300px;">
				<div id="photo">
					<img alt="" src="shopsave/<%=photo[0]%>" class="large">
					<div>
					<%
						// 사진이 여러개일경우만 반복문으로 처리
						if(photo.length>1){
							for(int i=0; i<photo.length; i++){
								%>
								<img src="shopsave/<%=photo[i]%>" class="small">
								<%
							}
						}
					%>
					</div>
				</div>
			</td>
			<td style="width: 300px; font-size: 10px;">
				<h3>카테고리 : <%=dto.getCategory() %></h3>
				<h3>상품명 : <%=dto.getSangpum()%></h3>
				<h3>가격 : <%=dto.getPrice() %></h3>
				<h3>색상 : 
				<%
					for(String co: color){
						%>
							<div class="colors"
							style="background-color: <%=co%>"></div>
						<%
					}
				%>
				</h3>
				
				<!-- 갯수 선택 -->
				<h3>갯 수 : 
					<input name="cnt" type="number" min="1" max="10" value="1"
					step="1">
				</h3>
				<h3>선택한 색상 :</h3>
				<div class="mycolor"
				style="background-color:<%=color[color.length-1]%>"></div>
				<div style="margin-top: 50px; margin-left: 60px;">
					<button type="button" class="btn btn-success"
					style="width: 100px;" id="btncart">장바구니</button>
					
					<button type="button" class="btn btn-info btn-lg"
					style="width:100px;"
					onclick="location.href='index.jsp?main=shop/shoplist.jsp'">상품목록</button>
				</div>
			</td>
		</tr>
	</table>
</form>
<script type="text/javascript">
$("#btncart").click(function(){
	var login = "<%=loginok%>";
	if(login=="null"){
		alert("먼저 로그인을 해주세요");
		return;
	}
	
	//form 태그의 모든값을 가져오기
	var formdata = $("#frm").serialize();
	//alert(formdata);
	
	$.ajax({
		type:"post",
		dataType:"html",
		url:"shop/detailprocess.jsp",
		data: formdata,
		success:function(data){
			var answer = confirm("장바구니에 담겠습니까?");
			if(answer){
				location.href="index.jsp?main=shop/mycart.jsp";
			}
		}
	});
});
</script>
</body>
</html>