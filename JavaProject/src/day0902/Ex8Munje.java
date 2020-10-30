package day0902;

import java.util.Scanner;

public class Ex8Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//이름과 kor,eng,mat 3과목의 점수를 입력하여
		//평균이 60 이상이고 각 과목이 40점이상이면
		//홍길동님은 자격증을 취득하였습니다
		//그렇지 않으면
		//홍길동님은 자격증 취득에 실패하였습니다
		Scanner sc=new Scanner(System.in);
		String name;
		int kor,eng,mat;
		double avg;
		System.out.println("이름입력");
		name=sc.nextLine();
		System.out.println("3과목의 점수 입력");
		kor=sc.nextInt();
		eng=sc.nextInt();
		mat=sc.nextInt();
		//평균
		avg=(kor+eng+mat)/3.0;
		System.out.printf("평균:%.1f\n",avg);
		
		System.out.println(name+" 님은 "+
				(avg>=60&&kor>=40&&eng>=40&&mat>=40?"자격증을 취득하였습니다":
					"자격증 취득에 실패하였습니다"));
	}

}





