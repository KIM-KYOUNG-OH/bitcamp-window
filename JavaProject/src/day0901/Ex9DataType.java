package day0901;

public class Ex9DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean b1=true;
		boolean b2=false;
		
		char c1='A';
		char c2='가';//자바에서의 char 는2바이트이므로 한글도 한글자가 온전히 저장
		System.out.println(c1);
		System.out.println(c2);
		System.out.printf("c1=%c,c2=%c\n",c1,c2);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(!b1);//!: not
		//제어문자열
		//\t:그다음탭위치에 출력
		//\n: 다음줄에 출력		
	}

}
