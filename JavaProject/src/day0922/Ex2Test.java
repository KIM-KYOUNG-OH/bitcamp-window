package day0922;

interface InterA
{
	public void draw();
	public void close();
}

class Apple
{
	public void show()
	{
		System.out.println("Apple �� show �޼���");
	}
}

//Orange Ŭ������ ���� Apple ���,InterA ����
class Orange extends Apple implements InterA
{
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Orane Ŭ�������� draw �޼��� ȣ��");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("Orane Ŭ�������� close �޼��� ȣ��");
	}
}


public class Ex2Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Orange ex1=new Orange();
		ex1.draw();
		ex1.close();
		ex1.show();
		System.out.println();
		Apple ex2=new Orange();
		ex2.show();
		System.out.println();
		InterA ex3=new Orange();
		ex3.draw();
		ex3.close();
	}
}










