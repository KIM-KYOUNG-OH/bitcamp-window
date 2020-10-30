package day0902;

import java.util.Scanner;

public class Ex11Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		//1~12 월을 입력후 몇일까지 있는지 출력
		//1~12가 아니면 "잘못입력했어요"
		
		//{} 안에서 선언하는 지역변수는 자동초기화가 안되고 그 안에는 쓰레기값이 들어가잇어서
		//반드시 값이 들어가있어야 오류가 안나요.
		int month,days=0;
		System.out.println("1~12 까지 월을 입력해주세요");
		month=sc.nextInt();
		switch(month)
		{
		case 4: case 6: case 9: case 11:
			days=30;
			break;
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			days=31;
			break;
		case 2:
			days=28;
			break;
		default:
			System.out.println("잘못입력했어요");
		}
		if(days>0)
			System.out.println(month+" 월은 "+days+"까지 있어요!!");
	}

}





