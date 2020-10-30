package day0904;

import java.util.Random;
import java.util.Scanner;

public class Ex9Baseball {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int 배열에 중복처리된 3개의 숫자를 넣은후 알아맞추기 게임
		 * 자리수가 틀리면 볼 변수 증가. 자릿수까지 맞으면 스트라이크 변수 증가
		 * 3 스트라이크가 나와야 정답입니다
		 */
		int []comsu=new int[3];//임의의 난수
		int []usersu=new int[3];//사용자가 입력하는 수 저장
		String number;//3자리의 숫자를 문자열 형태로 입력
		int strike,ball;
		Scanner sc=new Scanner(System.in);
		Random r=new Random();
		
		//comsu 에 1~9 사이의 중복되지 않은 수를 넣으세요
		Loop:
		for(int i=0;i<comsu.length;i++)
		{
			comsu[i]=r.nextInt(9)+1;
			for(int j=0;j<i;j++)
			{
				if(comsu[i]==comsu[j])
				{
					i--;
					continue Loop;
				}
			}
		}
		
		//System.out.printf("com %d %d %d\n",comsu[0],comsu[1],comsu[2]);
		
		while(true)
		{
			strike=ball=0;
			System.out.println("3자리 숫자를 입력하세요(공백없이)");
			number=sc.nextLine();
			//number를 usersu 에 배열형태로 분리해서 넣기
			//문자로 입력시 '1'은 정수로는 49(아스키코드표 참조)
			usersu[0]=number.charAt(0)-'0';
			usersu[1]=number.charAt(1)-'0';
			usersu[2]=number.charAt(2)-'0';
			//System.out.printf("user %d %d %d\n",usersu[0],usersu[1],usersu[2]);
			
			//comsu 와 usersu 를 비교하여 같은 숫자가 나오면 자릿수 비교후
			//자릿수까지 같으면 strike 변수 증가, 자릿수가 다르다면 ball변수 증가
			//strike 변수가 3이 되면 "축하합니다. 정답입니다(xxx)" 종료
			//다중 for문
			for(int i=0;i<comsu.length;i++)
			{
				for(int j=0;j<comsu.length;j++)
				{
					if(usersu[i]==comsu[j])
					{
						if(i==j)
							strike++;
						else
							ball++;
					}
				}
			}
			
			System.out.println(strike+" 스트라이크 "+ball+" 볼");
			if(strike==3)
			{
				System.out.println("축하합니다.정답입니다("+comsu[0]+comsu[1]+comsu[2]+")");
				break;
			}
			
		}
		
	}

}



























