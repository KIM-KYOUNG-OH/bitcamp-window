<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Anton&family=Black+Han+Sans&family=Jua&family=Yeon+Sung&display=swap" rel="stylesheet">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<style type="text/css">
	.frm{
		width: 250px;
	}
	
	input#price{
		width: 160px;
	}
	
	div.fg{
		margin-top: 5px;
	}
	
</style>
</head>
<body>
<div class="frm">
	<form class="form-inline" action="./moneyaction" method="get">
	  <div class="fg form-group">
	    <label for="pummok">품목:</label>
	    <input type="text" name="pummok" id="pummok" class="form-control" required="required" placeholder="상품명 입력">
	  </div>
	  <div class="fg form-group">
	    <label for="price">가격 :</label>
	    <input type="text" name="price" id="price" class="form-control" required="required" placeholder="가격 입력">&nbsp;원
	  </div>
	  <div class="fg form-group">
	    <label for="day">날짜 :</label>
	    <input type="date" name="day" class="form-control">
	  </div><hr>
	  <div class="container">
		<button type="submit" class="btn-primary">데이터 추가</button>&nbsp;
		<button type="button" class="btn-warning" onclick="history.back()">뒤로가기</button>
	  </div>
	</form>
</div>
</body>
</html>