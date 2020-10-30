package day0901;

public class Ex11DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//묵시적 형변환
		//int+int=int
		//char+int=int
		//byte+int=int
		//int+double=double
		//String+int=String
		//String+double=String
		
		char a='A';
		System.out.println(a+2);//결과는 자동으로 int
		System.out.println((char)(a+2));//(char) cast 연산자를 통해서 형변환
		System.out.println("^^:"+5+3);//+는 앞에서부터 연산-전체적으로 String
		System.out.println("^^:"+(5+3));//+ 는 먼저 계산되도록 하려면 () 로 묶어준다
		
		System.out.println(7/4);//결과는 int 1
		System.out.println(7.0/4);//둘중 하나는 double이라야 결과도 double로 정확히 나온다
		System.out.println(7/4.0);
		System.out.println((double)7/4);
	}

}
