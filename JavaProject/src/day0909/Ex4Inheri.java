package day0909;

abstract class Bujang
{
	abstract public void play();
	abstract public void draw();
}

abstract class Sawon1 extends Bujang
{
	abstract public void dataadd();
}

class Sawon2 extends Sawon1
{
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("�ǾƳ븦 ģ��");
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("�׸��� �׸���");
	}
	
	@Override
	public void dataadd() {
		// TODO Auto-generated method stub
		System.out.println("����Ÿ �߰��� �Ѵ�");
	}
}

public class Ex4Inheri {

	public static void process(Sawon1 s)
	{
		s.play();//�ǾƳ븦 ģ��
		s.draw();//�׸��� �׸���
		s.dataadd();//����Ÿ �߰����Ѵ�
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process(new Sawon2());
	}

}
