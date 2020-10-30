package day0907;

class MyMath
{
	public static int abs(int n)
	{
		if(n<0)
			n*=-1;
		return n;
	}
	public static double abs(double n)
	{
		if(n<0)
			n*=-1;
		return n;
	}
	public static float abs(float n)
	{
		if(n<0)
			n*=-1;
		return n;
	}
	
	public static char toLower(char ch)
	{
		if(ch>='A' && ch<='Z')
			ch+=32;
		return ch;
	}
	
	public static char toUpper(char ch)
	{
		if(ch>='a' && ch<='z')
			ch-=32;
		return ch;
	}
	
	public static int pow(int a,int b)
	{
		int result=1;
		for(int i=1;i<=b;i++)
			result*=a;
		return result;
	}
}


public class Ex12Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("** 절대값 구하기 **");
		System.out.println(Math.abs(-9));
		System.out.println(Math.abs(8));
		System.out.println(Math.abs(-1.2));
		System.out.println(Math.abs(3.4));
		System.out.println(Math.abs(-2.3f));
		System.out.println(Math.pow(3, 4));
		System.out.println("** 직접 메서드를 만들어보세요");
		System.out.println(MyMath.abs(-9));
		System.out.println(MyMath.abs(8));
		System.out.println(MyMath.abs(-1.2));
		System.out.println(MyMath.abs(3.4));
		System.out.println(MyMath.abs(-2.3f));
		
		System.out.println(MyMath.toLower('A'));//무조건 소문자로 출력
		System.out.println(MyMath.toLower('b'));
		System.out.println(MyMath.toUpper('D'));//무조건 대문자로 출력
		System.out.println(MyMath.toUpper('g'));
		System.out.println(MyMath.pow(3,4));//3의4승결과구하기
	}

}







