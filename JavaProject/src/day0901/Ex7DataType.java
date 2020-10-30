package day0901;

public class Ex7DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//정수의 종류 4가지
		//크기에 따라 byte(1),short(2),int(4),long(8)
		byte a=127;
		byte b=(byte) 200;//(타입) 강제연산자
		
		System.out.println("a="+a);
		System.out.println("b="+b);//강제로 형변환할경우에는 값손실이 발생할수 있다
		
		float f1=8.123456789f;//정밀도 7
		double f2=8.123456789;//정밀도 15
		System.out.println(f1);
		System.out.println(f2);
		
		//출력메서드
		//printf : jdk5 에서 추가, 변환기호를 이용해서 출력
		//정수:%d,실수:%f,1글자:%c,문자열%s
		System.out.printf("%d,%d,%f,%f\n",a,b,f1,f2);
		//실수형같은경우 소숫점 이하 자릿수 지정
		System.out.printf("%10.1f\n%10.2f\n%10.3f\n",f2,f2,f2);
	}

}








