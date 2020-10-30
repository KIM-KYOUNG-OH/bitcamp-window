package day0901;

import java.util.Scanner;

public class Ex12Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//이름과 국어,영어,수학 점수를 입력받아
		//이름,총점,평균을 출력하는데 평균은 소숫점이하 2자리까지만 출력
		//모두 printf 를 사용해서 출력하세요
		Scanner sc=new Scanner(System.in);
		//변수 선언
		String name;
		int kor,eng,mat;
		int tot;
		double avg;
		
		//입력
		System.out.println("Input name?");
		name=sc.nextLine();
		System.out.println("Input Kor score?");
		kor=sc.nextInt();
		System.out.println("Input Eng score?");
		eng=sc.nextInt();
		System.out.println("Input Mat score?");
		mat=sc.nextInt();
		
		//총점
		tot=kor+eng+mat;
		avg=(double)tot/3;
		
		//출력
		System.out.printf("이름 : %s\n",name);
		System.out.printf("총점 : %d\n",tot);
		System.out.printf("평균 : %5.2f\n",avg);
	}

}
