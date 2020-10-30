package day0901;

import java.util.Scanner;

public class Ex3Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//키보드로부터 값을 입력받는다
		Scanner sc=new Scanner(System.in);
		
		System.out.println("당신의 이름을 입력하세요 1");
		//이름을 입력받기 위한 변수 선언
		String name=sc.nextLine();//입력후 엔터누르면 한문장을 읽어온다
		//출력
		System.out.println("내 이름은 "+name+"입니다");
		
		System.out.println("당신의 이름을 입력하세요 2");
		//이름을 입력받기 위한 변수 선언
		String name2=sc.next();//입력후 엔터누르면 한단어만 읽어온다
		//출력
		System.out.println("내 이름은 "+name2+"입니다");
	}

}
