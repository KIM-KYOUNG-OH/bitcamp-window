package day0909;

abstract class Parent
{
	public void write()
	{
		System.out.println("Parent write");
	}
	
	public abstract void process(); 
}
//�θ�Ŭ������ �߻��ΰ�� �߻�޼��带 �������̵���ҰŸ�
//��ӹ��� Ŭ������ �߻�ȭ�Ѵ�
abstract class SubObj1 extends Parent
{
	public void hello()
	{
		System.out.println("SubObj1 hello");
	}
}

class SubWork extends SubObj1
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("�ᱹ ���� ��ó���Ѵ�. SubWork(û��)");
	}
}

class SubWork2 extends SubObj1
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("�ᱹ ���� ��ó���Ѵ�. SubWork2(�Ļ�)");
	}
}

public class Ex3Inheri {

	public static void process(Parent p)
	{
		p.process();
		p.write();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process(new SubWork());
		process(new SubWork2());
	}

}
