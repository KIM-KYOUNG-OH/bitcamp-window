package day0909;

interface Color
{
	public String getColor();
}

//인터페이스는 여러개 상속도 가능
interface Car extends Color
{
	public void write();
}

class My1 implements Color
{
	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return "빨강색";
	}
}

class My2 implements Car
{
	@Override
	public String getColor() {
		// TODO Auto-generated method stub
		return "분홍색";
	}
	
	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("내 차의 색상은 "+getColor()+"입니다");
	}
}

public class Ex8Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Color a1=new My1();
		System.out.println("내가 좋아하는 색상은 "+a1.getColor()+"입니다");
		
		Car a2=new My2();
		a2.write();
	}

}
