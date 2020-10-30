package day0902;

import java.util.Scanner;

public class Ex12If {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//윤년 공식
		//년도%4==0 && 년도%100!=0 || 년도%400==0 이면 윤년
		Scanner sc=new Scanner(System.in);
		int year;
		System.out.println("년도를 입력해주세요");
		year=sc.nextInt();
		
		if(year%4==0&&year%100!=0||year%400==0)
			System.out.println(year+"년도는 윤년입니다");
		else
			System.out.println(year+"년도는 평년입니다");
	}

}
