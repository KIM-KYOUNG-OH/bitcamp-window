package day0902;

import java.util.Scanner;

public class Ex7Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		//점수를 입력후 학점을 구하시오
		//90이상이면 'A',80이상이면 'b',...60 미만은 'F'
		//출력은 (예) 78 점은 C학점입니다
		int score;
		char grade;
		System.out.println("점수를 입력해주세요");
		score=sc.nextInt();
		grade=score>=90?'A':score>=80?'B':score>=70?'C':
			score>=60?'D':'F';
		System.out.printf("%d 점은 %c 학점입니다\n",score,grade);	
		//80이상이면 "통과",70 이상이면 "재시험",그 나머지는 "탈락"
		System.out.println("당신은 "+(score>=80?"통과":score>=70?"재시험":"탈락"));
	}

}
