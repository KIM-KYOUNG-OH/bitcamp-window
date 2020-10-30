$(function(){
	//1. 총을 클릭하면 0~11 사이의 값을 랜덤하게 발생하여
	// 선반위의 해당 인형을 안보이게 처리한다
	$('.gun').click(function(){
		var idx = parseInt(Math.random()*12);
		// idx가 발생하면 해당 인형이 이미 사라진경우에는
		// '3번 인형은 이미 처리되었습니다'
		// 그렇지 않으면 '3번 인형을 맞췄네요!!!'
		// 그러다가 모두 맞추면 'game over!!! you win!!'라고 출력
		// 힌트: is(':hidden')
		if($(".sunban li img").eq(idx).is(':hidden')){
			$('#msg').text((idx+1)+'번은 이미 처리되었습니다');
		}else{
			$(".sunban li img").eq(idx).fadeOut('fast');
			$('#msg').text((idx+1)+'번은 인형을 맞췄네요!!');
		}
		
		// hidden의 갯수 세기
		var n = 0
		$('.sunban li img').each(function(index){
			//hidden상태일 경우 변수 n을 1증가
			if($(this).is(':hidden')){
				n++;
			}
		});
		
		if(n==12){
			$('#msg').text('game over!! you win!!');
		}
	});
	
	//지폐를 클릭하면 해당 지폐는 안보이게 처리하고
	//인형은 모두 다시 보이게 하기 메세지창도 지우기
	$('ul.money li img').click(function(){
		$(this).hide();
		$('ul.sunban li img').show();
		$('#msg').text('');
	});
});