package day0908;

class SuperObj2
{
	String name;
	int age;
	
	SuperObj2()
	{
		System.out.println("�θ� ������ ȣ��");
		name="ȫ�浿";
		age=20;
	}
	
	public void write()
	{
		System.out.println("�̸�:"+name);
		System.out.println("����:"+age);
	}
}
////////////////////////////////////
class SubObj2 extends SuperObj2
{
	String hp;
	SubObj2()
	{
		super();//�����Ǿ��ִ�.�θ�Ŭ������ ����Ʈ ������ ȣ��
		System.out.println("�ڽ� ������ ȣ��");
		hp="010-222-3333";
	}
	
	@Override
	public void write() {
		// TODO Auto-generated method stub
		super.write();
		System.out.println("�ڵ���:"+hp);
	}
}

public class Ex10Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubObj2 sub=new SubObj2();
		//write�� ����Ŭ�������� �������̵�Ǿ��մٸ� 
		//����Ŭ������ write�� ȣ��ȴ�
		//���� ���ٸ� �θ�Ŭ������ write ��ȣ��ȴ�
		sub.write();
	}

}





