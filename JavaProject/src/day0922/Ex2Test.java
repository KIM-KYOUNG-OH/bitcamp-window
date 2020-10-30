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
		System.out.println("Apple 의 show 메서드");
	}
}

//Orange 클래스를 구현 Apple 상속,InterA 구현
class Orange extends Apple implements InterA
{
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Orane 클래스에서 draw 메서드 호출");
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		System.out.println("Orane 클래스에서 close 메서드 호출");
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










