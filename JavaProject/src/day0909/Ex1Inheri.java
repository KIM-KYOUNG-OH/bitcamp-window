package day0909;

class Fruit
{
	public void show()
	{
		System.out.println("Fruit show");
	}
}

class Apple extends Fruit
{
	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();
		System.out.println("Apple show");
	}
	
	public void play()
	{
		System.out.println("�ڹٰ��θ� ����");
	}
}

public class Ex1Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apple a1=new Apple();
		a1.show();//apple �� ���� show ȣ��
		a1.play();
		System.out.println();
		Fruit a2=new Apple();
		//�θ� Ŭ������ ����,����Ŭ������ ������
		//�������̵�� �޼��常 ȣ���� �����ϴ�
		a2.show();
		//a2.play();//����
	}

}









