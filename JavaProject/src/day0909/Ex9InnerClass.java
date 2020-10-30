package day0909;

class Outer
{
	int a=1;
	static int b=2;
	
	class Inner
	{
		int c=3;
		//static int d=4;//��� ����Ŭ���������� static ���� ���� �Ұ�
		
		public void disp()
		{
			System.out.println("a="+a);
			System.out.println("b="+b);
			System.out.println("c="+c);
			//System.out.println("d="+d);			
		}
	}
	
	//static ����Ŭ����-static ������ ������ ����������
	//�ܺ�Ŭ������ �ν��Ͻ� ��������� ������ �Ұ����ϴ�
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
		//����Ŭ������ �ܺ�Ŭ������ ���ؼ� ����
		Outer.Inner ex1=new Outer().new Inner();
		ex1.disp();
		System.out.println();
		//static ���� Ŭ���� ����
		Outer.Inner2 ex2=new Outer.Inner2();
		ex2.disp();
	}

}












