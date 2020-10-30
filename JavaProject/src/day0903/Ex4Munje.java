package day0903;

import java.util.Random;
import java.util.Scanner;

public class Ex4Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1~100 사이의 난수를 임의로 발생후 그 숫자 알아맞추기
		//예: 67 이발생
		//56 입력시 : 56보다 큽니다
		//89 입력시 : 89보다 작습니다
		//67 입력시 : 정답입니다(67)-계속(y or n)? y 누르면 새로운 난수-게속 알아맞추기
		//y 가 아닐경우 "** 정상종료 **" 출력후 종료
		
		Scanner sc=new Scanner(System.in);
		Random r=new Random();
		Exit:
		while(true)
		{
			System.out.println("새로운 난수를 발생합니다");
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
					System.out.println("계속하려면 y 를,그만하려면 n을 눌러주세요");
					//버퍼의 엔터 읽어서 제거하기
					sc.nextLine();
					char ans=sc.nextLine().charAt(0);
					//if(!(ans=='y'||ans=='Y'))
					if(ans!='y' && ans!='Y')	
						break Exit;//외부 while문을 빠져나간다
					else
						continue Exit;//바깥쪽 반복문의 조건식으로 이동
				}				
			}
		}
		
		System.out.println("** 정상 종료 **");
	}

}













