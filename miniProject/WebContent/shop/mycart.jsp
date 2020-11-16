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
	
	#selcolor{
		width: 40px;
		height: 40px;
		border: 1px solid black;
	}
	
	span.del{
		cursor: pointer;
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
	
	$("div.sangpum").click(function(){
		var shopnum = $(this).attr("shopnum");
		location.href="index.jsp?main=shop/detailpage.jsp?shopnum="+shopnum;
	});
	
	// 체크한 상품 삭제 버튼
	$(".btndel").click(function(){
		// 체크한 상품 갯수 구하기
		var cnt = $(".idx:checked").length;
		if(cnt==0){
			alert("먼저 삭제할 상품을 선택해주세요");
			return;
		}
		
		$(".idx:checked").each(function(i, element){
			var idx=$(this).attr("idx");
			console.log(idx); // 선택한 상품의 idx만 나오는지 반드시 확인하기
			
			// 선택한 장바구니 상품 모두 삭제하기
			del(idx);
		});
		//새로고침
		location.reload();
	});
	
	// 선택한 상품 한개만 삭제시 이벤트
	$("span.del").click(function(){
		var idx = $(this).attr("idx");
		var a = confirm("삭제하려면 [확인]을 눌러주세요");
		if(a){
			del(idx);
			location.reload();
		}
	});
});

//사용자함수
function del(idx){
	$.ajax({
		type:"get",
		url:"shop/cartdelete.jsp",
		dataType:"html",
		data:{"idx":idx},
		success:function(data){}
	});
}
</script>
</head>
<%
	// 로그인한 아이디 얻기
	String id = (String)session.getAttribute("myid");
	// shopDao 선언
	ShopDao dao = new ShopDao();
	// 장바구니 목록 얻기
	List<HashMap<String,String>> list = dao.getCartList(id);
	
	NumberFormat nf = NumberFormat.getInstance();
	
	int allmoney = 0;
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
					상품명: <%=map.get("sangpum") %><br>
					개수: <%=map.get("cnt") %><br>
					카트 추가 날짜: <%=map.get("cartday") %>		
				</div>
			</td>
			<td>
				<div>
					<h4>선택한 색상</h4>
					<div id="selcolor" 
					style="background-color: <%=map.get("mycolor") %>"></div>
				</div>
			</td>
			<td align="right" style="vertical-align: middle;">
				<%
					// 원화표시로 format
					int price = Integer.parseInt(map.get("price"));
					allmoney += price;
				%>
				<h4><%=nf.format(price)%>원</h4>
					<span class="del glyphicon glyphicon-trash"
					idx="<%=map.get("idx")%>"></span>
					
			</td>
		</tr>
		<%
	}
	%>
	<tr>
		<td colspan="4">
			<button type="button" class="btndel btn btn-danger btn-lg"
			style="margin-left: 100px;" id="btncartdel">선택상품삭제</button>
			
			<span style="font-size: 2em; float: right;">총 주문 금액
			<b style="color: green;"><%=nf.format(allmoney) %>원</b></span>
		</td>
	</tr>
</table>
</body>
</html>