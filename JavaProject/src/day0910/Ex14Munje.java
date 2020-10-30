package day0910;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import day0908.Person;

public class Ex14Munje {
	List<Person> list;
	Scanner sc;
	
	public Ex14Munje() {
		// TODO Auto-generated constructor stub
		list=new ArrayList<Person>();
		sc=new Scanner(System.in);
	}
	
	public void dataAdd()
	{
		System.out.println("이름입력");
		String name=sc.nextLine();
		System.out.println("태어난 년도 입력");
		int year=Integer.parseInt(sc.nextLine());
		System.out.println("키 입력");
		double height=Double.parseDouble(sc.nextLine());
		System.out.println("몸무게 입력");
		double weight=Double.parseDouble(sc.nextLine());
		
		Person p=new Person();
		p.setName(name);
		p.setYear(year);
		p.setHeight(height);
		p.setWeight(weight);
		
		//리스트에 추가
		list.add(p);
		System.out.println(list.size()+"번째 데이타 추가!!");		
	}
	
	public void dataDel()
	{
		System.out.println("삭제할 이름 입력");
		String name=sc.nextLine();
		boolean find=false;//찾으면 true 로 변경
		for(int i=0;i<list.size();i++)
		{
			Person p=list.get(i);//list 에서 i번째 person 데이타를 얻는다
			//p 의 이름과 입력한 이름이 같으면 i번째 데이타를 삭제
			if(p.getName().equals(name))
			{
				find=true;
				//삭제
				list.remove(i);
				break;//반복문 빠져나가기
			}
		}
		if(find)
			System.out.println(name+"님의 데이타를 삭제했습니다");
		else
			System.out.println(name+"님은 명단에 없습니다");
	}
	
	public void dataAllWrite()
	{
		System.out.println("\t\tPerson 명단");
		System.out.println();
		System.out.println("이름\t년도\t띠\t키\t몸무게\t평가");
		for(Person p:list)
			System.out.println(p.getName()+"\t"+p.getYear()+"\t"+p.getddi()+"\t"+
					p.getHeight()+"\t"+p.getWeight()+"\t"+p.getPungga());
	}
	
	public int getMenu()
	{
		int menu;
		System.out.println("1.추가  2.삭제  3.전체출력  4.종료");
		System.out.println("번호를 선택하세요");
		menu=Integer.parseInt(sc.nextLine());
		return menu;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex14Munje ex=new Ex14Munje();
		while(true)
		{
			switch(ex.getMenu())
			{
			case 1:
				ex.dataAdd();
				break;
			case 2:
				ex.dataDel();
				break;
			case 3:
				ex.dataAllWrite();
				break;
			default:
				System.out.println("** 프로그램을 종료합니다 **");
				System.exit(0);
			}
			System.out.println();
		}
	}

}









