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
</head>
<body>
<form action="ex14_action.jsp" method="post" class="form-inline">
	<table class="table table-border" style="width: 500px;">
		<caption><h3>회원 정보</h3></caption>
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
				서버에 전송</button>
			</td>
		</tr>
	</table>
</form>
<script type="text/javascript">
	// 1. 핸드폰 4자리 입력시 다음 번호칸으로 이동
	$("#hp2").keyup(function(){
		var hp2 = $(this).val();
		if(hp2.length >= 4){
			$("#hp3").focus();
		}		
	});
	
	// 2. 이메일 선택시 앞칸에 이메일주소 출력
	// 직접쓰기일경우 기존 이메일 지우고 포커스 주기
	$("#email3").change(function(){
		var choice = $(this).val();
		if(choice=="-"){
			$("#email2").val("");
			$("#email2").focus();
		}else{
			$("#email2").val(choice);
		}
	});
	
</script>
</body>
</html>

























