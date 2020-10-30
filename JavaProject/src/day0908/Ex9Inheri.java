package day0908;

class SuperObj
{
	public void dispA()
	{
		System.out.println("super dispA");
	}
	
	void dispB()
	{
		System.out.println("super dispB");
	}
	
	protected void dispC()
	{
		System.out.println("super dispC");
	}
	
	private void dispD()
	{
		System.out.println("super dispD");
	}
}

//상속
class SubObj extends SuperObj
{
	public void disp()
	{
		this.dispA();
		this.dispB();
		this.dispC();
		//this.dispD();//오류 private 은 상속안됨
	}
}

public class Ex9Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubObj s1=new SubObj();
		s1.disp();
		System.out.println();
		s1.dispA();
		s1.dispB();
		s1.dispC();
	}

}








