package day0902;

import java.util.Scanner;

public class Ex2Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//산술연산자 문제
		//금액을 입력하면 만원:21장,천원:4개...1원:3개 
		//위처럼 출력되도록 프로그램을 작성해주세요
		//예: 764532..만원:76장,천원:4개...1원:2개
		Scanner sc=new Scanner(System.in);
		int money;
		System.out.println("금액을 입력해주세요");
		money=sc.nextInt();
		System.out.println("만원 :"+money/10000);
		System.out.println("천원 :"+(money%10000)/1000);
		System.out.println("백원 :"+(money%1000)/100);
		System.out.println("십원 :"+(money%100)/10);
		System.out.println("일원 :"+money%10);		
	}

}
