package day0903;

import java.util.Random;
import java.util.Scanner;

public class Ex3Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1~100 사이의 난수를 임의로 발생후 그 숫자 알아맞추기
		//예: 67 이발생
		//56 입력시 : 56보다 큽니다
		//89 입력시 : 89보다 작습니다
		//67 입력시 : 정답입니다(67)-프로그램 종료
		Scanner sc=new Scanner(System.in);
		Random r=new Random();
		//1~100 사이의 난수 발생
		int ran=r.nextInt(100)+1;
		int su,cnt=0;
		while(true)
		{
			System.out.println("숫자입력("+ ++cnt+")");
			su=sc.nextInt();
			if(su>ran)
				System.out.println(su+"보다 작습니다");
			else if(su<ran)
				System.out.println(su+"보다 큽니다");
			else {
				System.out.println("정답입니다("+ran+")");
				break;
			}
			
		}
		System.out.println("** 정상 종료 **");
	}
}













