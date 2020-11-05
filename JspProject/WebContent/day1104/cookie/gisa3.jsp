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
4일 강원도 동부전선 전방에서 미상 인원이 철책에 접근한 상황이 포착돼 군 당국이
 대침투경계령인 ‘진돗개’를 발령하고 수색작전을 벌이고 있다.

군 관계자 등에 따르면 전날 저녁 해당 지역에서 미상 인원 1명이 북측 지역에서 
철조망을 넘어 남쪽으로 내려온 것으로 알려졌다.

군사 분계선에는 북측과 남측, 그리고 그 사이 중간 철조망이 있는데, 군 감시장비를
 통해 신원을 알수 없는 인원이 중간 철조망으로 이동하는 것이 식별됐다는 것이다.

군 당국이 해당 지역을 수색한 결과 남쪽 윤형 철조망 상단부가 일부 눌려 있는 것을
 확인, 신원 미상자가 철조망을 넘은 것으로 추정하고 있다.

합참은 이날 “현재 동부지역 전방에서 미상 인원이 우리 군 감시장비에 포착되어 작전
 중에 있다”면서 “구체적인 내용은 작전이 종료되면 설명하겠다”고 밝혔다.

군은 대침투경계령인 ‘진돗개 둘’을 발령했다.

귀순 가능성도 제기되지만 침투한 인원이 군인인지 민간인지는 아직 확인되지 않았다.

‘진돗개’는 무장공비 침투 등 북한의 국지도발 가능성에 대비한 방어 준비태세로 
연대장급 이상 지휘관이 발령할 수 있다.
</pre>
<%} %>
</body>
</html>