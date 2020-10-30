package day0901;

import java.util.Scanner;

public class Ex4Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		//변수 선언
		int year;
		double su1,su2;
		//입력
		System.out.println("태어난 년도를 입력하세요");
		year=sc.nextInt();
		
		System.out.println("실수타입의 두숫자를 입력해주세요");
		su1=sc.nextDouble();
		su2=sc.nextDouble();
		
		//출력
		System.out.println("나는 "+year+"년생입니다");
		System.out.println("두과목의 합은 "+(su1+su2)+" 입니다");
		
	}

}
