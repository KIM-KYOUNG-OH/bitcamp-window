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
기아차 노조가 올해 임금 및 단체협약(임단협) 요구안 관철을 위해 합법적인 파업권 
확보에 돌입했다. 신종 코로나바이러스 감염증(코로나19) 여파로 이미 고사 위기에 
내몰린 부품 협력사들은 불안을 호소하고 있다.

4일 기아차 노조에 따르면 전일 조합원을 대상으로 실시한 쟁위행위 찬반투표가 73.3%의
 찬성률로 가결됐다. 전체 조합원 2만9261명 가운데 2만6222명이 참여했고, 2만1457명이
  파업에 찬성했다.

기아차 노조가 지난달 중앙노동위원회(중노위) 낸 쟁의조정 신청도 이날 조정중지 
결정이 나올 전망이다. 기아차 노조는 찬반투표 결과에 더해 중노위의 조정중지 
결정도 받아 합법적인 파업권을 갖추고 협상력을 높여 임단협 협상을 본격 추진한다는 방침이다.

기아차의 2020년 임단협은 9차례 교섭에도 난항을 거듭하는 중이다. 노조는 
△기본급 12만원 인상 △영업이익 30% 성과급 배분 △정년 60세에서 65세로 연장 
△통상임금 확대 적용 △잔업 복원 △노동이사제 도입 △전기차 핵심 부품 생산 등을 요구하고 있다.
</pre>
<%} %>
</body>
</html>