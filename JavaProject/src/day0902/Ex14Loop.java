package day0902;

public class Ex14Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//while:선조건,do~while:후조건
		int n=10;
		//조건이 안맞으면 내부코드 실행안함
		while(n>10)
		{
			System.out.println("hello");
		}
		
		//조건이 안맞아도 일단 한번은 실행한다
		do {
			System.out.println("Hello 2");
		}while(n>10);
		
		n=0;
		while(n<=5)
		{
			System.out.println(++n);//6까지 출력
		}
		
		n=0;
		do {
			System.out.println(++n);//6까지 출력
		}while(n<=5);
	}

}

















