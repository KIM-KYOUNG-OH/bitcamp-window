package day0907;

public class Ex10Overloading {

	//overloading method:�޼������ ���� ���ڰ� ���� �ٸ� �޼���
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
		System.out.println(name+" �� ���̴� "+age+"���Դϴ�");
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
		write("����");
		write("����",23);
		
		sum(3,5);//�հ����
		sum(1,2,3);//�հ����
		sum(1.9,2.3);//�հ����
		sum("apple","orange");//���ڿ� ���ؼ� ����
	}
}












