package day0909;

interface Color
{
	public String getColor();
}

//�������̽��� ������ ��ӵ� ����
interface Car extends Color
{
	public void write();
}

class My1 implements Color
{
	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return "������";
	}
}

class My2 implements Car
{
	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return "��ȫ��";
	}
	
	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("�� ���� ������ "+getColor()+"�Դϴ�");
	}
}

public class Ex8Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Color a1=new My1();
		System.out.println("���� �����ϴ� ������ "+a1.getColor()+"�Դϴ�");
		
		Car a2=new My2();
		a2.write();
	}

}
