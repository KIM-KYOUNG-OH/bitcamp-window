package day0909;

class Outer
{
	int a=1;
	static int b=2;
	
	class Inner
	{
		int c=3;
		//static int d=4;//멤버 내부클래스에서는 static 변수 선언 불가
		
		public void disp()
		{
			System.out.println("a="+a);
			System.out.println("b="+b);
			System.out.println("c="+c);
			//System.out.println("d="+d);			
		}
	}
	
	//static 내부클래스-static 변수는 선언이 가능하지만
	//외부클래스의 인스턴스 멤버변수는 접근이 불가능하다
	static class Inner2
	{
		int c=3;
		static int d=4;
		public void disp()
		{
			//System.out.println("a="+a);
			System.out.println("b="+b);
			System.out.println("c="+c);
			System.out.println("d="+d);			
		}
	}
	
	public void show()
	{
		Inner in=new Inner();
		in.disp();
	}
}

public class Ex9InnerClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//내부클래스는 외부클래스를 통해서 생성
		Outer.Inner ex1=new Outer().new Inner();
		ex1.disp();
		System.out.println();
		//static 내부 클래스 선언
		Outer.Inner2 ex2=new Outer.Inner2();
		ex2.disp();
	}

}












