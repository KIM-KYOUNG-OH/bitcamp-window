package day0902;

import java.util.Scanner;

public class Ex17Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		//while문 문제
		//점수(score) 를 입력하다가 0을 입력하면 반복문을
		//빠져나와 총 갯수,총점,평균(소숫점1자리) 출력하기
		//변수 선언
		int score,count=0,sum=0;
		double avg;
		while(true)
		{
			//점수 입력
			System.out.println("점수 입력");
			score=sc.nextInt();
			//빠져나가는 조건
			if(score==0)
				break;
			//입력값을 sum 에 더하기
			sum+=score;
			//count 증가
			count++;			
		}
		//평균구하기
		avg=(double)sum/count;
		//출력
		System.out.println("총 갯수:"+count);
		System.out.println("합계:"+sum);
		System.out.printf("평균:%.1f\n",avg);
	}

}




