package day0903;

import java.util.Scanner;

public class Ex13Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//10명의 나이를 입력후 각 연령별 인원을 출력하시오
		//출력예
		//전체 데이타도 출력하고
		//10대   : 3명
		//....50대까지 출력
		//입력시 10세 미만이거나 60세 이상이면 다시 입력
		Scanner sc=new Scanner(System.in);
		int []person=new int[10];
		int []inwon=new int[5];//배열에 인원수를 구함(0번지는 10대인원수,1번지는 20대 인원수)
		
		//나이 입력
		for(int i=0;i<person.length;i++)
		{
			System.out.println(i+"번지 나이:");
			int n=sc.nextInt();
			if(n<10 || n>=60)
			{
				System.out.println("\t다시 입력해주세요(10~59)");
				i--;
				continue;//i++ 로 이동
			}
			person[i]=n;
			//인원수 계산
			inwon[n/10-1]++;
		}
		System.out.println("** 전체 나이 출력 **");
		for(int i=0;i<person.length;i++)
			System.out.print(i+":"+person[i]+"  ");
		System.out.println();
		
		System.out.println("** 연령별 인워수 **");
		for(int i=0;i<inwon.length;i++)
		{
			System.out.println((i+1)*10+"대:"+inwon[i]+"명");
		}
	}

}





















