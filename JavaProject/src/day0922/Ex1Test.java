package day0922;

class SuperObj
{
	SuperObj()
	{
		System.out.println("super ������ ȣ��");
	}
	
	public void process()
	{
		System.out.println("�θ� Ŭ�������� ��ó�� �ϴ� �޼���");
	}
}

class SubObj extends SuperObj
{
	SubObj()
	{
		System.out.println("sub ������ ȣ��");
	}
	
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("�ڽ� Ŭ�������� ���� ��ó���� �Ѵ�");
		super.process();		
	}
	
	public void show()
	{
		System.out.println("���� Ŭ�������� ������ �ִ� �޼���");
	}
}

public class Ex1Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubObj s1=new SubObj(); //�θ� �����ڰ� ���� ȣ��ǰ� �ڽ� ������ ȣ��
		s1.process();//sub Ŭ������ ���� process �� ȣ��
		s1.show();
		
		SuperObj s2=new SubObj(); //�θ�Ŭ������ ����
		s2.process();//�������̵�� �޼��常 ȣ���� �����ϴ�
		//s2.show();//���� �߻�
	}

}









