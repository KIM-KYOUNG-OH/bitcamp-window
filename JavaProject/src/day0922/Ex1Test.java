package day0922;

class SuperObj
{
	SuperObj()
	{
		System.out.println("super 생성자 호출");
	}
	
	public void process()
	{
		System.out.println("부모 클래스에서 일처리 하는 메서드");
	}
}

class SubObj extends SuperObj
{
	SubObj()
	{
		System.out.println("sub 생성자 호출");
	}
	
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("자식 클래스에서 먼저 일처리를 한다");
		super.process();		
	}
	
	public void show()
	{
		System.out.println("서브 클래스만이 가지고 있는 메서드");
	}
}

public class Ex1Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubObj s1=new SubObj(); //부모 생성자가 먼저 호출되고 자식 생성자 호출
		s1.process();//sub 클래스가 가진 process 가 호출
		s1.show();
		
		SuperObj s2=new SubObj(); //부모클래스로 선언
		s2.process();//오버라이드된 메서드만 호출이 가능하다
		//s2.show();//오류 발생
	}

}









