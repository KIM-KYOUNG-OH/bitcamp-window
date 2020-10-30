package day0909;

class Fruit
{
	public void show()
	{
		System.out.println("Fruit show");
	}
}

class Apple extends Fruit
{
	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();
		System.out.println("Apple show");
	}
	
	public void play()
	{
		System.out.println("자바공부를 하자");
	}
}

public class Ex1Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apple a1=new Apple();
		a1.show();//apple 이 가진 show 호출
		a1.play();
		System.out.println();
		Fruit a2=new Apple();
		//부모 클래스로 선언,서브클래스로 생성시
		//오버라이드된 메서드만 호출이 가능하다
		a2.show();
		//a2.play();//오류
	}

}









