<%@page import="data.dto.MemberDto"%>
<%@page import="data.dao.MemberDao"%>
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
	// 이메일 주소 선택시 자동입력
	$("#email3").change(function(){
		var p = $(this).children("option:selected").attr('value');
		$("#email2").val(p);
	});
	
	// 주소 검색파일 오픈
	$("#btnpost").click(function(){
		window.open("member/postsearch.jsp","",
				"left=100px,top=100px,width=400px,height=250px"); 
	});
	
});
</script>
</head> 
<%
	// num 읽기
	request.setCharacterEncoding("utf-8");
	String num = request.getParameter("num");
	// db로부터 getData 호출후 폼안에 값 넣어주기
	MemberDao dao = new MemberDao();
	
	MemberDto dto = dao.getData(num);
%>
<body>
<form action="member/updateaction.jsp" method="post" 
class="form-inline" name="memberform">
<input type="hidden" id='num' name="num" value="<%=dto.getNum()%>"> 
<input type="hidden" id='id' name="id" value="<%=dto.getId()%>"> 
	<table class="table table-border" style="width: 500px;">
		<caption><h3>회원 정보 수정</h3></caption>
		<tr>
			<td align="center" width="100"><b>아이디</b></td>
			<td>
				<b><%=dto.getId()%></b>
			</td>
		</tr>
		
		<tr>
			<td align="center" width="100"><b>이름</b></td>
			<td>
				<div class="form-group">
					<input type="text" id="name" name="name" class="form-control" required='required'
					value="<%=dto.getName() %>">
				</div>
			</td>
		</tr>
		<tr>
			<td align="center" width="100"><b>핸드폰</b></td>
			<td>
				<div class="form-group">
				<select name="hp1">
					<option value="02" 
						<%=dto.getHp1().equals("02")?"selected":""%>>02</option>
					<option value="010"
						<%=dto.getHp1().equals("010")?"selected":""%>>010</option>
					<option value="019"
						<%=dto.getHp1().equals("019")?"selected":""%>>019</option>
				</select>
				<input type="text" name="hp2" id='hp2' class="form-control"
				maxlength = "4" style="width: 80px;" required='required' value="<%=dto.getHp2() %>">
				<input type="text" name="hp3" id='hp3' class="form-control"
				maxlength = "4" style="width: 80px;" required='required' value="<%=dto.getHp3() %>">
				</div>
			</td>
		</tr>
		<tr>
			<td align="center" width="100"><b>주소</b></td>
			<td>
				<div class="form-group">
					<input type="text" id="address" name="address" class="form-control" value="<%=dto.getAddress() %>"
					style="width: 300px; background-color: #eee; readonly='readonly';" required='required'>
					<button type="button" class="btn btn-danger btn-sm" id="btnpost">주소검색</button>					
					<br>
					<input type="text" name="addrdetail" class="form-control input-sm" required='required'
					style="width: 350px;" value="<%=dto.getAddrdetail() %>">
				</div>
			</td>
		</tr>
		<tr>
			<td align="center" width="100"><b>이메일</b></td>
			<td>
				<div class="form-group">
					<input type="text" name="email1" id="email1" style="width: 80px;" class="form-control"
					 required='required' value="<%=dto.getEmail1()%>">
					<b>@</b>
					<input type="text" name="email2" id="email2" style="width: 100px;" class="form-control"
					value="<%=dto.getEmail2()%>">
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
			<td align="center" width="100"><b>비밀번호 확인</b></td>
			<td>
				<div class="form-group">
					<input type="text" id="password" name="pass" class="form-control"
					style="width: 100px;" required='required' value="<%=dto.getPass()%>">
					<!--  
					pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
					title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters"
					-->
				</div>
			</td>
		</tr>
		<tr>
			<td colspan='2' align='center'>
				<button type="submit" class="btn btn-danger">회원 정보 수정</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>