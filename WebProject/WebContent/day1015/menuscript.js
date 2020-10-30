//메인만 남기고 서브메뉴는 안보이게 하기
$(function(){
	$('ul.submenu').hide();
	$('li.main').hover(function(){
		$(this).children('ul').slideDown("100");
	}, function(){
		$(this).children('ul').slideUp("100");
	});
});
