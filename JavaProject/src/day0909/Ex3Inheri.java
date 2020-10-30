package day0909;

abstract class Parent
{
	public void write()
	{
		System.out.println("Parent write");
	}
	
	public abstract void process(); 
}
//부모클래스가 추상인경우 추상메서드를 오버라이드안할거면
//상속받은 클래스도 추상화한다
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
		System.out.println("결국 내가 일처리한다. SubWork(청소)");
	}
}

class SubWork2 extends SubObj1
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("결국 내가 일처리한다. SubWork2(식사)");
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
