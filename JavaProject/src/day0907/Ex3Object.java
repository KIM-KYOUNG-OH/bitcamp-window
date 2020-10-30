package day0907;

//지역 클래스
//public 을 붙일수 없다
//같은 패키지내에서만 접근이 가능(파일은 달라도 상관없음)
class Apple
{
	int score=100;
	final static String MESSAGE="Have a Nice Day!!!";
}

//public 접근지정자는 파일명과 같은 클래스 앞에만 붙일수 있더
//public 이 붙은 클래스는 다른 패키지에서도 생성이 가능하다
public class Ex3Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Apple 크래스의 score와 MESSAGE 상수를 출력해보세요
		Apple app=new Apple();
		System.out.println(app.score);
		System.out.println(Apple.MESSAGE);
		
		Apple app2=new Apple();
		app2.score=90;
		System.out.println(app2.score);
		System.out.println(Apple.MESSAGE);
	}

}
