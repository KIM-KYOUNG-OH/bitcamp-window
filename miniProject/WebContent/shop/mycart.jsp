<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.ShopDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div.sangpum{
		cursor: pointer;
	}
	
	div.sangpum img.photo{
		width: 60px;
		height: 90px;
		border: 2px solid gray;
	}
	
	#detail{
		padding-left: 40px;
		padding-top: 10px;
	}
	
	#selcolor{
		width: 40px;
		height: 40px;
		border: 1px solid black;
	}
</style>
<script type="text/javascript">
$(function(){
	// allcheck클릭시 전체 체크 on/off
	$("#allcheck").click(function(){
		if(!$("#allcheck").prop("checked")){
			$(".idx").prop("checked",false);
		}else{
			$(".idx").prop("checked",true);
		}
	});
	
	// 선택 상품 삭제
	$("#del").click(function(){
		var items = [];
		$("input.idx:checkbox").each(function(){
			items.push($(this).attr("idx"));		
		});
		console.log(items);
	});
	
	
	
	
	
	
});
</script>
</head>
<%
	// 로그인한 아이디 얻기
	String id = (String)session.getAttribute("myid");
	// shopDao 선언
	ShopDao dao = new ShopDao();
	// 장바구니 목록 얻기
	List<HashMap<String,String>> list = dao.getCartList(id);
%>
<body>
<h4 class="alert alert-warning" style="width: 1200px;">
	<%=id%> 님의 장바구니
</h4>
<table class="table table-striped" style="width: 1200px;">
	<tr>
		<th style="width: 30px;">
			<input type="checkbox" id="allcheck">
		</th>
		<th style="width: 400px;">상품정보</th>
		<th style="width: 200px;">옵션</th>
		<th style="width: 200px;">상품금액</th>
	</tr>
	<%
	for(int i=0; i<list.size(); i++){
		HashMap<String, String> map = list.get(i);
		// 사진은 첫번째 사진만 얻기
		String photo = map.get("photo").split(",")[0];
		%>
		<tr>
			<td align="center">
				<input type="checkbox" name="idx" class="idx" 
				idx="<%=map.get("idx")%>">
			</td>
			<td>
				<div shopnum="<%=map.get("shopnum")%>" class="sangpum">
					<img alt="" src="shopsave/<%=photo%>" class="photo"
					align="left" hspace="20">				
				</div>
				<div id="detail">
					상품명: <%=map.get("sangpum") %><br>
					개수: <%=map.get("cnt") %><br>
					카트 추가 날짜: <%=map.get("cartday") %>
				</div>
			</td>
			<td>
				<div>
					선택한 색상<br>
					<div id="selcolor" 
					style="background-color: <%=map.get("mycolor") %>"></div>
				</div>
			</td>
			<td>
				<div>
					<%
						// 원화표시로 format
						int price = Integer.parseInt(map.get("price"));
						String money="";
						money = NumberFormat.getCurrencyInstance(Locale.KOREA).format(price);
					%>
					<%=money%>
				</div>
			</td>
		</tr>
		<%
	}
	%>
</table><hr>
<div>
	<button type="button" id="del" class="btn-danger">선택상품삭제</button>
</div>
</body>
</html>