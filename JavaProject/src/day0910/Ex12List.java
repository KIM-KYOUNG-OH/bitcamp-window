package day0910;

import java.util.List;
import java.util.Vector;

import day0908.Person;

public class Ex12List {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Person> list=new Vector<Person>();
		list.add(new Person("이효리", 1989, 167.3, 56.8));
		list.add(new Person("강호동", 1970, 189.2, 89.6));
		list.add(new Person("이영자", 1997, 160.2, 66.8));
		list.add(new Person("임영웅", 2001, 178.3, 65.8));
		System.out.println("총 "+list.size()+" 명의 데이타가 있습니다");
		System.out.println("출력 1");
		for(Person p:list)
		{
			System.out.println(p.getName()+"\t"+p.getYear()+"\t"+
					p.getHeight()+"\t"+p.getWeight()+"\t"+p.getPungga());
		}
		System.out.println();
		System.out.println("출력 2");
		for(int i=0;i<list.size();i++)
		{
			Person p=list.get(i);
			System.out.println(i+1+"\t"+p.getName()+"\t"+p.getYear()+"\t"+
					p.getHeight()+"\t"+p.getWeight()+"\t"+p.getPungga());
		}
		
	}

}







