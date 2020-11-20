<%@page import="java.util.List"%>
<%@page import="java.sql.Array"%>
<%@page import="java.util.ArrayList"%>
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
	
	div#answer{
		margin-left: 300px;
		margin-top: 30px;
	}
	
	#content{
		width: 300px;
		height: 50px;
		float: left;
	}
	
	#addanswer{
		width: 80px;
		height: 50px;
		line-height: 50px;
		margin-left: 5px;
	}
	
	.commentwriteday{
		margin-left:900px;
	}
	
	span.del:hover{
		cursor: pointer;
	}
	
	/*댓글 목록 전체*/
	#answerlist{
		margin-left: 150px;
		margin-top: 30px;
		font-size: 14px;
		width: 500px;
	}
	
	/*댓글날짜 출력부분*/
	span.aday{
		float: right;
		color: gray;
	}
	
	/*답글버튼*/
	span.abtn{
		cursor: pointer;
		width: 50px;
		border: 1px solid black;
		float: right;
		font-size: 12px;
	}
	
	pre.answer{
		width: 300px;
		margin-left: 160px;
		font-weight: bold;
	}
	
	div.shoptag{
		width: 400px;
		margin-left: 200px;
		margin-bottom: 10px;
	}
	
	div shoptag textarea{
		float: left;
		width: 300px;
	}
	
	div.shoptag .shopsave{
		width: 60px;
		height: 55px;
	}
	
	span.acancel{
		cursor: pointer;
		width: 60px;
		font-weight: bold;
	}
	
	span.adel{
		font-size: 0.6em;
		cursor: pointer;
		margin-left:20px;
	}
</style>
<script type="text/javascript">
$(function(){
	// 처음 상품 디테일 출력시 기존 댓글도 출력하기
	answerlist();
	
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
	
	// 댓글 추가버튼 이벤트
	$("#addanswer").click(function(){
		//ajax 함수로 처리
		//readanswer.jsp 로 myid,shopnum,content 3개를 보내서
		//해당 jsp파일에서 db에 insert 한다
		//성공하면 사용자함수 answerlist()를 호출하고
		//입력창의 값들은 지워주세요
		var myid=$("#myid").val();
		var shopnum = $("#shopnum").val();
		var content = $("#content").val();
		console.log(myid,shopnum,content);
		$.ajax({
			type:"post",
			dataType:"html",
			url:"shop/readanswer.jsp",
			data:{"myid":myid,"shopnum":shopnum,"content":content},
			success:function(data){
				answerlist();
				$("#content").val("");
			}
		});
	});
	
	// 답글달기
	$(document).on("click","span.abtn",function(){
		var idx = $(this).attr("idx");
		//console.log(idx);
		var tag = "<div class='shoptag'>";
		tag += "<textarea class='form-control acontent'></textarea>";
		tag += "<button class='shopsave btn btn-xs btn-danger' idx='"
			+idx+ "'>저장</button>";
		tag += "<span class='acancel'>취소</span></div>";
		$(this).after(tag); // 답글달기 버튼 바로 아래에 추가
		$(this).hide(); // 답글달기는 안보이게 처리
	});
	
	// 주인 답글 취소
	$(document).on("click","span.acancel",function(){
		// 안보이게 처리했던 답글달기를 다시 보이게 하기
		$(this).parent().prev('span.abtn').show();
		// 바로 위의 태그인 div제거
		$(this).parent('div.shoptag').remove();
	});
	
	// 주인 답글 저장 부분
	$(document).on("click","button.shopsave",function(){
		var my = $(this);
		var idx = $(this).attr("idx");
		//console.log(idx);
		var acontent = $(this).prev('.acontent').val();
		//console.log(acontent);
		if(acontent.length==0){
			alert("답글을 입력후 저장해주세요");
			return;
		}else{
			$.ajax({
				type:"post",
				dataType:"html",
				url:"shop/answerupdate.jsp",
				data:{"idx":idx,"acontent":acontent},
				success:function(data){
					my.parent().remove();
					answerlist();
				}
			});
		}
	});
	
	// 댓글 삭제 아이콘 이벤트
	$(document).on("click","span.adel",function(){
		var idx=$(this).attr("idx");
		var a = confirm("삭제하시겠습니까?");
		// 취소일경우 함수 종료
		if(!a){
			return;
		}
		// 삭제
		$.ajax({
			type:"get",
			dataType:"html",
			url:"shop/deleteanswer.jsp",
			data:{"idx":idx},
			success:function(data){
				answerlist();
			}
		});
	});
});

// 사용자함수 추가
function answerlist(){
	var loginid = $("#myid").val(); // 로그인한 아이디
	var shopnum = $("#shopnum").val() // 현재 페이지 상품의 번호
	$.ajax({
		type:"get",
		dataType:"xml",
		url:"shop/answerlist.jsp",
		data:{"shopnum":shopnum},
		success:function(data){
			var s = "";
			$(data).find("answer").each(function(i,element){
				var n = $(this);
				// 작성자
				s += "<b>"+n.find("name").text()+"</b>";
				// 삭제표시 본인것만 보이게
				var myid = n.find("myid").text();
				if(loginid==myid){
					s+="<span class='adel glyphicon glyphicon-trash' idx='"+
					n.find("idx").text()+"'></span>";
				}
				// 날짜
				s += "<span class='aday'>" +n.find("writeday").text()+"</span><br>";
				// 내용
				s += "<pre class='acontent'>" +n.find("content").text()+"</pre>";
				// 답글
				var answer = n.find("shopanswer").text();
				if(answer=='no'){
					s+="<span class='abtn' idx='"
					+n.find("idx").text()+"'>답글달기</span><br>";
				}else{
					s+= "<pre class='answer'>[샵주인]<br>"+answer+"</pre>";
				}
				s += "<hr>";
			});
			$("#answerlist").html(s);
		}
	});
}
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
<%
// 댓글 입력창은 로그인을 해야만 보인다
	if(loginok!=null){
		
%>
<div id="answer">
	<form id="answerfrm">
		<input type="hidden" id="myid" value="<%=myid%>">
		<input type="hidden" id="shopnum" value="<%=dto.getShopnum()%>">
		
		<textarea id="content" class="form-control"></textarea>
		<button type="button" id="addanswer">추가</button>
	</form>
</div>
<%}%>
<div id="answerlist">
	댓글 목록
</div>
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