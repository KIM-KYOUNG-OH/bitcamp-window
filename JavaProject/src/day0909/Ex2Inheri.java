package day0909;

//abstract(�߻� �Ǵ� �̿ϼ�) �޼��带 �ϳ��̻� ���� Ŭ������
//�ݵ�� �߻�ȭ���Ѿ� �Ѵ�. ����� class �տ� abstract �� ���̸� �ȴ�
//�� �߻�ȭ�� Ŭ������ �����Ҽ� ����(���� ����)
//�� �߻� Ŭ������ ��ӹ޴� ����Ŭ������ �߻� �޼ҵ带 �ݵ�� �������̵��ؾ߸� �Ѵ�
//���� ���Ұ�� ����Ŭ������ �߻�ȭ���Ѿ߸� �Ѵ�
abstract class Fruit2
{
	//�θ� ���� �޼��尡 �������̵常�� �������� �ϰ�
	//���� ó���� �۾��� ���ٸ� �߻� �޼���� �����ϸ� �ȴ�
	//�߻��� abstract ��� �ܾ ���̴µ� �̿ϼ� �޼����� �ǹ��̴�
	abstract public void show();		
}

class Apple2 extends Fruit2
{
	@Override
	public void show() {
		System.out.println("Apple2 show");
	}
}

class Kiwi2 extends Fruit2
{
	@Override
	public void show() {
		System.out.println("Kiwi2 show");
	}
}

class Orange2 extends Fruit2
{
	@Override
	public void show() {
		System.out.println("Orange2 show");
	}
}


public class Ex2Inheri {

	public static void process(Fruit2 f)
	{
		f.show();//Apple2,Kiwi2,Orange2 �� ��ó��(������ó��)
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�θ� Ŭ������ ����� ����Ŭ�������� �����Ҽ� �ִ�
		//���� �����ؼ� ���� �ϴ� �������
		//�� �������̵�� �޼��常 ȣ���� �����ϴ�
		Fruit2 f=null;
		f=new Apple2();
		f.show();
		
		f=new Kiwi2();
		f.show();
		
		f=new Orange2();
		f.show();
		System.out.println();
		System.out.println("�޼��带 ���ؼ� ��ó���ϱ�");
		process(new Apple2());
		process(new Kiwi2());
		process(new Orange2());
	}

}









