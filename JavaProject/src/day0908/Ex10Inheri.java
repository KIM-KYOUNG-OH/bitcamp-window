package day0908;

class SuperObj2
{
	String name;
	int age;
	
	SuperObj2()
	{
		System.out.println("부모 생성자 호출");
		name="홍길동";
		age=20;
	}
	
	public void write()
	{
		System.out.println("이름:"+name);
		System.out.println("나이:"+age);
	}
}
////////////////////////////////////
class SubObj2 extends SuperObj2
{
	String hp;
	SubObj2()
	{
		super();//생략되어있다.부모클래스의 디폴트 생성자 호출
		System.out.println("자식 생성자 호출");
		hp="010-222-3333";
	}
	
	@Override
	public void write() {
		// TODO Auto-generated method stub
		super.write();
		System.out.println("핸드폰:"+hp);
	}
}

public class Ex10Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubObj2 sub=new SubObj2();
		//write가 서브클래스에서 오버라이드되어잇다면 
		//서브클래스의 write가 호출된다
		//만약 없다면 부모클래스의 write 가호출된다
		sub.write();
	}

}





