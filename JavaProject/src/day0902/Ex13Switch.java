package day0902;

import java.util.Scanner;

public class Ex13Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		//jdk8부터는 switch 에서 문자열도 가능
		String msg;
		System.out.println("게임,쇼핑,종료중 한단어를 입력해주세요");
		msg=sc.nextLine();
		switch(msg)
		{
		case "게임":
			System.out.println("게임 레벨 업!!!");
			break;
		case "쇼핑":
			System.out.println("쇼핑 목록 추가!!");
			break;
		case "종료":
			System.out.println("오늘 일과를 종료합니다");
			break;
		default:
			System.out.println("무엇을 원하시나요...");
		}
	}

}
