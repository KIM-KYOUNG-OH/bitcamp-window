package day0909;
//�������̽��� ��ӹ޴� Ŭ������ �������� �������̽��� ���ÿ� ������ �����ϴ�
interface AA
{
	public void add(int a,int b);
}

interface BB
{
	public void sub(int a,int b);
}

class Suhak implements AA,BB
{
	@Override
	public void add(int a, int b) {
		// TODO Auto-generated method stub
		System.out.printf("%d + %d = %d\n",a,b,a+b);
	}
	@Override
	public void sub(int a, int b) {
		// TODO Auto-generated method stub
		System.out.printf("%d - %d = %d\n",a,b,a-b);
	}
}

public class Ex7Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Suhak Ŭ������ ������ ���");
		Suhak s=new Suhak();
		s.add(3, 6);
		s.sub(7, 3);
		System.out.println();
		
		System.out.println("AA �������̽��� ������ ���");
		AA a=new Suhak();
		a.add(10, 30);//�������̵��� �޼��常 ȣ�� ����
		System.out.println();
		
		System.out.println("BB �������̽��� ������ ���");
		BB b=new Suhak();
		b.sub(6, 2);
		
	}

}







