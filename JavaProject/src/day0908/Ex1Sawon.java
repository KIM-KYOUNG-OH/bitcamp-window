package day0908;

import java.util.Scanner;

import day0907.Sawon;

public class Ex1Sawon {
	Sawon []sa;
	int inwon;
	Scanner sc;
	
	public Ex1Sawon()
	{
		sc=new Scanner(System.in);
	}
	
	//데이타 입력하는 메서드
	public void dataAdd()
	{
		System.out.println("인원수를 입력하세요");
		inwon=Integer.parseInt(sc.nextLine());
		//메모리 할당
		sa=new Sawon[inwon];
		//인원수만큼 사원정보 입력해서 배열에 저장
		for(int i=0;i<inwon;i++)
		{
			System.out.println("사원명 입력");
			String name=sc.nextLine();
			System.out.println("나이입력");
			int age=Integer.parseInt(sc.nextLine());
			System.out.println("혈액형입력");
			String blood=sc.nextLine();
			System.out.println("급여 입력");
			int pay=Integer.parseInt(sc.nextLine());
			System.out.println("수당입력");
			int sudang=Integer.parseInt(sc.nextLine());
			
			//i번째 사원 클래스 생성하면서 값전달
			sa[i]=new Sawon(name, age, blood, pay, sudang);
			System.out.println();			
		}
	}
	
	//출력하는 메서드
	public void dataWrite()
	{
		System.out.println("번호\t이름\t나이\t혈액형\t급여\t수당\t총금액");
		for(int i=0;i<inwon;i++)
		{			
			System.out.println(i+1+"\t"+sa[i].getName()+"\t"+sa[i].getAge()
					+"\t"+sa[i].getBlood()+"\t"+sa[i].getPay()+"\t"+sa[i].getSudang()
					+"\t"+sa[i].getTotal());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1Sawon ex=new Ex1Sawon();
		ex.dataAdd();
		ex.dataWrite();
	}

}








