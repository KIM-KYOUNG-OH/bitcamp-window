package day0908;

import java.text.NumberFormat;
import java.util.Scanner;

class Salary
{
	private String name;
	private int salary;
	
	Salary(String n,int s)
	{
		name=n;
		salary=s;
	}
	
	public void getInfomation()
	{
		NumberFormat nf=NumberFormat.getCurrencyInstance();
		System.out.print(name+"\t"+nf.format(salary));
	}
}

class Sawon extends Salary
{
	private String department;
	
	Sawon(String n,int s,String d)
	{
		super(n,s);
		department=d;
	}
	
	@Override
	public void getInfomation() {
		// TODO Auto-generated method stub
		super.getInfomation();
		System.out.println("\t"+department);
	}
}

public class Ex16InheriMunje {
	Sawon []sawon;
	Scanner sc;
	int inwon;
	
	public Ex16InheriMunje() {
		// TODO Auto-generated constructor stub
		sc=new Scanner(System.in);
	}
	
	public void sawonAdd()
	{
		System.out.println("인원수 입력");
		inwon=Integer.parseInt(sc.nextLine());
		//할당
		sawon=new Sawon[inwon];
		for(int i=0;i<inwon;i++)
		{			
			System.out.println(i+1+"번째 사원의 정보 입력");
			System.out.println("사원명");
			String name=sc.nextLine();
			System.out.println("연봉");
			int salary=Integer.parseInt(sc.nextLine());
			System.out.println("부서");
			String depart=sc.nextLine();
			
			//생성
			sawon[i]=new Sawon(name, salary, depart);
		}
	}
	
	public void sawonWrite()
	{	
		
		System.out.println("번호\t사원명\t연봉\t부서");
		for(int i=0;i<inwon;i++)
		{
			System.out.print(i+1+"\t");
			sawon[i].getInfomation();//sub class(sawon)의 getInfomation 호출
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex16InheriMunje ex=new Ex16InheriMunje();
		ex.sawonAdd();
		ex.sawonWrite();
	}

}







