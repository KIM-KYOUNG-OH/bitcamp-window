package day0907;

public class Ex2Object {
	//멤버 변수, 상수
	int x=10;//인스턴스 멤버 변수
	static int y=20;//클래스변수, 정적변수
	final String MSG1="Happy";//상수 지정
	static final String MSG2="Nice";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//static 멤버 메서드는 this라는 인스턴스를 가지고 있지 않다
		//일반 멤버 메서드는 this라는 인스턴스를 가지고 있기때문에
		//this.x 이런식으로 접근이 가능한것이다(물론 이때 this는 생략도 가능)
		
		//System.out.println(x);//접근 안됨
		System.out.println(Ex2Object.y);//static 변수 접근은 클래스명.변수
		System.out.println(y);//클래스명은 같은 클래스내에서는 생략 가능
		
		//인스턴스 멤버 변수를 static 메소드내에서 호출하고 싶다면
		Ex2Object ob=new Ex2Object();
		System.out.println(ob.x);//인스턴스변수.변수명
		
		//상수출력
		System.out.println(ob.MSG1);
		System.out.println(Ex2Object.MSG2);
		System.out.println(MSG2);
		
		//깂 변경 안됨
		//MSG2="Hello";//에러
	}

}
