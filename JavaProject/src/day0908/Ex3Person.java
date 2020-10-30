package day0908;

import java.util.Scanner;

public class Ex3Person {
	Person []per;
	Scanner sc;
	int inwon;
	
	public Ex3Person() {
		// TODO Auto-generated constructor stub
		System.out.println("생성자");
		sc=new Scanner(System.in);
	}
	public void dataAdd()
	{
		//인원수를 입력후 인원수만큼 데이타 입력
		System.out.println("인원수");
		inwon=Integer.parseInt(sc.nextLine());
		//배열 할당
		per=new Person[inwon];
		for(int i=0;i<inwon;i++)
		{
			per[i]=new Person();
			
			System.out.println("이름");
			String name=sc.nextLine();
			per[i].setName(name);
			
			System.out.println("태어난 년도");
			int year=Integer.parseInt(sc.nextLine());
			per[i].setYear(year);
			
			System.out.println("키");
			double height=Double.parseDouble(sc.nextLine());
			per[i].setHeight(height);
			
			System.out.println("몸무게");
			double weight=Double.parseDouble(sc.nextLine());
			per[i].setWeight(weight);		
			
		}
	}
	
	public void dataWrite()
	{
		//출력
		//번호,이름,태어난년도,띠,키,몸무게,평가
		System.out.println("번호\t이름\t년도\t띠\t키\t몸무게\t평가");
		for(int i=0;i<per.length;i++)
		{
			Person p=per[i];
			System.out.println(i+1+"\t"+p.getName()+"\t"+p.getYear()+"\t"+
			p.getddi()+"\t"+p.getHeight()+"\t"+p.getWeight()+"\t"+p.getPungga());
//			System.out.println(p);
		}		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3Person ex=new Ex3Person();
		ex.dataAdd();
		ex.dataWrite();
	}

}

