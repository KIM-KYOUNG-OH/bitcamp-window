package day0902;

import java.util.Scanner;

public class Ex25Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//숫자를 입력하면 1부터 그 숫자까지의 합을 구하시오
		//예) 100 을 입력하면  5050
		Scanner sc=new Scanner(System.in);
		int su,sum=0;
		System.out.println("숫자 입력");
		su=sc.nextInt();
		for(int i=1;i<=su;i++)
		{
			sum+=i;
		}
		System.out.println("1부터 "+su+"까지의 합은 "+sum+" 입니다");
		System.out.println();
		
		//2 3 을 입력하면 "2의3승은 8입니다" 라고 출력
		//3 3 을 입력하면 "3의3승은 27입니다" 라고 출력
		int x,y,sum2=1;
		System.out.println("지수승을 구할 두 숫자 입력");
		x=sc.nextInt();
		y=sc.nextInt();
		
		for(int i=1;i<=y;i++)
		{
			sum2*=x;
		}
		System.out.printf("%d 의 %d 승은 %d 입니다",x,y,sum2);
	}

}










