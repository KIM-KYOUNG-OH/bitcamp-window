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
		System.out.println("피아노를 친다");
	}
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("그림을 그린다");
	}
	
	@Override
	public void dataadd() {
		// TODO Auto-generated method stub
		System.out.println("데이타 추가를 한다");
	}
}

public class Ex4Inheri {

	public static void process(Sawon1 s)
	{
		s.play();//피아노를 친다
		s.draw();//그림을 그린다
		s.dataadd();//데이타 추가를한다
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process(new Sawon2());
	}

}
