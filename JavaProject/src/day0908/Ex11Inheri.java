package day0908;

class SuperObj3
{
	//���������� ����Ʈ�� ���� ��Ű���ϰ�쿡�� ������ �����ϴ�
	String name;
	int age;
	
	SuperObj3()
	{
		System.out.println("�θ� ������ ȣ��");
	}	
}
////////////////////////////////////
class SubObj3 extends SuperObj3
{
	String hp;
	SubObj3()
	{
		System.out.println("�ڽ� ������ ȣ��");
		name="�̹���";
		age=30;
		hp="010-222-3333";
	}

	public void write() {
		// TODO Auto-generated method stub
		System.out.println("�̸�:"+name);
		System.out.println("����:"+age);
		System.out.println("�ڵ���:"+hp);
	}
}

public class Ex11Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubObj3 sub=new SubObj3();
		//write�� ����Ŭ�������� �������̵�Ǿ��մٸ� 
		//����Ŭ������ write�� ȣ��ȴ�
		//���� ���ٸ� �θ�Ŭ������ write ��ȣ��ȴ�
		sub.write();
	}

}





