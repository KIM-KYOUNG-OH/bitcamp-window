package day0907;
/*
 * ������
 * 1. ����Ÿ���� ����
 * 2. �޼������ Ŭ������� ����
 * 3. �ߺ�ó���� �����ϴ�
 * 4. �ַ� ��������� �ʱⰪ�� ����Ѵ�
 */
class Hello
{
	Hello()
	{
		System.out.println("����Ʈ ������ ȣ��");
	}
	
	Hello(String str)
	{
		System.out.println("������ ȣ��");
		System.out.println("���޹��� ���ڿ� "+str);
	}
	
	Hello(String name,int age)
	{
		System.out.println("Name:"+name+",Age:"+age);
	}
	
}

public class Ex13Construc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hello h1=new Hello("Hello");
		Hello h2=new Hello();
		Hello h3=new Hello("�̿���",23);
	}

}







