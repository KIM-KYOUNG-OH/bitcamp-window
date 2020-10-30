package day0902;

import java.util.Scanner;

public class Ex9If {

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
		//if
		if(score>=90) 
			grade='A';
		else if(score>=80) grade='B';
		else if(score>=70) grade='C';
		else if(score>=60) grade='D';
		else grade='F';
		System.out.println(score+"점은 "+grade+" 학점입니다");			
		
		//switch
		switch(score/10)
		{
		case 10:
		case 9:
			grade='A';
			break;
		case 8:
			grade='B';
			break;
		case 7:
			grade='C';
			break;
		case 6:
			grade='D';
			break;
		default:
			grade='F';
		}
		System.out.println(score+"점은 "+grade+" 학점입니다");	
	}

}













