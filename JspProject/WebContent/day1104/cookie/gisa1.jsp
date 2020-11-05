<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	// 현재 도메인에 저장되어있는 모든 쿠키 가져오기
	Cookie []cookies = request.getCookies();
	boolean isLogin = false; // 쿠키가 존재하면 true
	// 저장된 쿠키가 하나도 없다면 null
	if(cookies!=null){
		for(Cookie cook: cookies){
			// 쿠키 이름 얻기
			String cookieName=cook.getName();
			// 쿠키에 저장된 값 얻기
			String cookieValue = cook.getValue();
			System.out.println(cookieName + "," +cookieValue);
			//loginok라는 쿠키가 있고 값이 success가 들어있다면 성공적으로 로그인했다는 뜻
			//생성안된 상태에서 널값일 경우 오류가 나기 때문에 널 조건도 추가
			if(cookieName.equals("loginok") && cookieValue!=null
				&& cookieValue.equals("success")){
					isLogin = true;
				}
		}
	}
%>
<body>
<%
	if(!isLogin){%>
		<script type="text/javascript">
			alert("먼저 로그인을 해주세요");
			history.back();
		</script>
	<%}else{%>
		<pre>
당시 미2사단 지역대 지원장교 김모 대위, 대검에 고발장 제출
당시 추미애 전 보좌관으로부터
서씨 병가 연장 요건 문의 받아
동부지검장 “김 대위 진술 달라 못 믿어”
김 대위 “일부러 거짓말한 게 아니다”
김 대위, 스스로 3년 전 휴대전화 복원해
“서씨 휴가 연장 승인 받은 적 없다”고
검찰에 제출했으나 미채택…秋 무혐의로
군 복무 특혜 의혹이 제기됐던 추미애 법무부 장관 아들 서모(27)씨의 상사였던 
미2사단 지역대의 지원장교 김모 대위 측이 서씨 사건을 수사한 김관정 서울동부지검장을 명예훼손 혐의로 고발했다.

4일 법조계에 따르면 김 대위 측은 “김 지검장이 국정감사장에서 김 대위에
대한 허위사실을 유포해 명예를 훼손했다”며 최근 대검찰청에 고발장을 냈다.

김 대위는 2017년 6월 당시 추미애 더불어민주당 대표의 보좌관으로부터 서씨의
병가 연장 요건 등의 문의를 받은 인물이다.

앞서 김 지검장은 지난달 19일 서울고검과 산하 검찰청 국정감사에서 서씨와 엇갈린
진술을 한 김 대위의 진술을 배척한 이유에 대해 “지원장교가 4회 진술을 했는데 한 번도
같은 적이 없었다”면서 “(검찰이) 압수수색하기 전에 지원장교가 휴대전화 통화기록을
다 지웠다”며 김 대위 진술의 신빙성을 믿기 어렵다는 취지로 답했다.
</pre>
	<%}
%>
</body>
</html>