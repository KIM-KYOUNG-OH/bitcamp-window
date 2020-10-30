package day0907;

public class Ex10Overloading {

	//overloading method:메서드명은 같고 인자가 서로 다른 메서드
	public static void write(int n)
	{
		System.out.println(n);
	}
	
	public static void write(int n,int m)
	{
		System.out.println(n+m);
	}
	
	public static void write(String name)
	{
		System.out.println("My name is "+name);
	}
	
	public static void write(String name,int age)
	{
		System.out.println(name+" 의 나이는 "+age+"세입니다");
	}
	
	public static void sum(int a,int b)
	{
		System.out.println(a+b);
	}
	
	public static void sum(int a,int b,int c)
	{
		System.out.println(a+b+c);
	}
	
	public static void sum(double a,double b)
	{
		System.out.println(a+b);
	}
	
	public static void sum(String a,String b)
	{
		System.out.println(a+b);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		write(20);
		write(3,5);
		write("미자");
		write("영자",23);
		
		sum(3,5);//합계출력
		sum(1,2,3);//합계출력
		sum(1.9,2.3);//합계출력
		sum("apple","orange");//문자열 더해서 나열
	}
}












