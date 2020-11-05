<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<script type="text/javascript">
$(function(){
	// 주소 검색파일 오픈
	$("#btnpost").click(function(){
		window.open("member/postsearch.jsp","",
				"left=100px,top=100px,width=400px,height=250px");
	});
	
	// 아이디 입력시 메세지 지우기
	$("#id").keydown(function(){
		$("b.idcheck").html("");
	});
	$("#id").blur(function(){
		var id = $("#id").val();
		if(id.trim().length==0){
			$(this).val("");
			return;
		}
		$.ajax({
			type:"get",
			url:"member/idcheckxml.jsp",
			dataType:"xml",
			data:{"id":id},
			success:function(data){
				var isExist = $(data).text();
				if(isExist=="yes"){
					$(".idcheck").html("이미 존재하는 아이디입니다");
					$(".idcheck").css({
						"color":"red",
						"font-size":"14px"
					});
				}else{
					$(".idcheck").html("사용가능한 아이디입니다");
					$(".idcheck").css({
						"color":"green",
						"font-size":"14px"
					});
				}
			}
		});
	});
});
</script>
</head> 
<body>
<form action="member/insertaction.jsp" method="post" 
class="form-inline" name="memberform">
	<table class="table table-border" style="width: 500px;">
		<caption><h3>회원 가입</h3></caption>
		<tr>
			<td align="center" width="100"><b>아이디</b></td>
			<td>
				<div class="form-group">
					<input type="text" id="id" name="id" class="form-control"
					style="width: 100px; autofocus='autofocus';" required='required'>
					<b class="idcheck"></b>
				</div>
			</td>
		</tr>
		<tr>
			<td align="center" width="100"><b>비밀번호</b></td>
			<td>
				<div class="form-group">
					<input type="text" id="password" name="pass" class="form-control"
					style="width: 100px;"
					<%--
					pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
					title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
					--%>
					>
				</div>
			</td>
		</tr>
		<tr>
			<td align="center" width="100"><b>이름</b></td>
			<td>
				<div class="form-group">
					<input type="text" id="name" name="name" class="form-control">
				</div>
			</td>
		</tr>
		<tr>
			<td align="center" width="100"><b>핸드폰</b></td>
			<td>
				<div class="form-group">
				<select name="hp1">
					<option value="02">02</option>
					<option value="010" selected="selected">010</option>
					<option value="019">019</option>
				</select>
				<input type="text" name="hp2" id='hp2' class="form-control"
				maxlength = "4" style="width: 80px;">
				<input type="text" name="hp3" id='hp3' class="form-control"
				maxlength = "4" style="width: 80px;">
				</div>
			</td>
		</tr>
		<tr>
			<td align="center" width="100"><b>주소</b></td>
			<td>
				<div class="form-group">
					<input type="text" id="address" name="address" class="form-control"
					style="width: 300px; background-color: #eee; readonly='readonly';">
					<button type="button" class="btn btn-danger btn-sm" id="btnpost">주소검색</button>					
					<br>
					<input type="text" name="addrdetail" class="form-control input-sm"
					style="width: 350px;">
				</div>
			</td>
		</tr>
		<tr>
			<td align="center" width="100"><b>이메일</b></td>
			<td>
				<div class="form-group">
					<input type="text" name="email1" id="email1" style="width: 80px;" class="form-control">
					<b>@</b>
					<input type="text" name="email2" id="email2" style="width: 100px;" class="form-control">
					<select id='email3' class="form-control">
						<option selected disabled hidden="">이메일선택</option>
						<option value="-">직접작성</option>
						<option value="naver.com">네이버</option>
						<option value="nate.com">네이트</option>
						<option value="gmail.com">구글</option>
					</select>
				</div>
			</td>
		</tr>
		<tr>
			<td align="center" width="100"><b>성별</b></td>
			<td>
				<div class="form-group">
					<input type="radio" class="form-control" name="gender"
					value="남자" checked="checked">남자	
					<input type="radio" class="form-control" name="gender"
					value="여자" checked="checked">여자	
				</div>
			</td>
		</tr>
		<tr>
			<td colspan='2' align='center'>
				<button type="submit" class="btn btn-danger">
				회원 가입</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>