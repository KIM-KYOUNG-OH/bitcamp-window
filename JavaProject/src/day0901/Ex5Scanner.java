package day0901;

import java.util.Scanner;

public class Ex5Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		//숫자,문자 순서로 입력을 받아보자		
		int age;
		String name;
		
		System.out.println("나이를 입력하세요");
		age=sc.nextInt();//숫자만 읽어옴
		//키보드 버퍼의 엔터를 따로 읽어서 없앤다
		sc.nextLine();
		
		System.out.println("이름을 입력하세요");
		name=sc.nextLine();
		
		System.out.println("name="+name);
		System.out.println("age="+age);
		
	}

}
