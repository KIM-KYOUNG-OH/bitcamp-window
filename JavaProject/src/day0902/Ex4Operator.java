package day0902;

public class Ex4Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//증감연산자 ++,--
		//단항일경우는 앞에 또는 뒤에 어디에 붙던 상관없다
		//단항이 아닐경우는 전치일경우는 1순위, 후치일경우는 끝순위
		int a=5,b=5;
		++a;//전치 a=a+1
		b++;//후치 b=b+1
		System.out.println(a+","+b);//6,6
		//출력시 증감 연산자 사용
		System.out.println(++a);//7,증가하고 출력
		System.out.println(b++);//6, 출력하고 증가
		
		System.out.println(a+","+b);//7,7
		
		int m,n;
		m=n=6;
		a=b=5;
		a+=m++ - --b;//--,+=,++
		System.out.printf("%d,%d,%d\n",a,b,m);//7,4,7
		m=n=a=b=3;
		m=++a;//먼저 증가후 대입
		n=b++;//먼저 대입후 증가
		System.out.printf("%d,%d,%d,%d\n",a,b,m,n);//4,4,4,3
		
	}

}







