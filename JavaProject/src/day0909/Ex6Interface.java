package day0909;

//interface 는 final상수와 abstract 추상메소드로만 구성
//음식점의 메뉴판과 같다(실체가 없다)
interface InterA
{
	String MSG="Happy";//final 생략
	public void showMessage();//abstract 생략
}

class WorkA implements InterA
{
	@Override
	public void showMessage() {
		// TODO Auto-generated method stub
		System.out.println(MSG);
		//MSG="Hello";//오류,상수이므로 변경 불가
	}
}

class WorkB implements InterA
{
	String msg=MSG;
	@Override
	public void showMessage() {
		// TODO Auto-generated method stub
		System.out.println("초기값:"+msg);
		msg="Nice";
		System.out.println("변경:"+msg);
	}
}


public class Ex6Interface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterA a=new WorkA();
		a.showMessage();
		
		a=new WorkB();
		a.showMessage();
	}

}
