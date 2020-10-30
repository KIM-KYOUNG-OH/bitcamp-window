package day0901;

public class Ex2DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//두개의 숫자를 args인자로 받아서 사칙연산을 계산해보자
		double su1=Double.parseDouble(args[0]);
		double su2=Double.parseDouble(args[1]);
		
		//3.5 2.1 을 인자에 넣어주세요
		System.out.println("더하기:"+(su1+su2));
		System.out.println("빼기:"+(su1-su2));
		System.out.println("곱하기:"+(su1*su2));
		System.out.println("나누기:"+(su1/su2));		
	}

}
