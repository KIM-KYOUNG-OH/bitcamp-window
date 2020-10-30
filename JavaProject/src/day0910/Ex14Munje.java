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
		System.out.println("�̸��Է�");
		String name=sc.nextLine();
		System.out.println("�¾ �⵵ �Է�");
		int year=Integer.parseInt(sc.nextLine());
		System.out.println("Ű �Է�");
		double height=Double.parseDouble(sc.nextLine());
		System.out.println("������ �Է�");
		double weight=Double.parseDouble(sc.nextLine());
		
		Person p=new Person();
		p.setName(name);
		p.setYear(year);
		p.setHeight(height);
		p.setWeight(weight);
		
		//����Ʈ�� �߰�
		list.add(p);
		System.out.println(list.size()+"��° ����Ÿ �߰�!!");		
	}
	
	public void dataDel()
	{
		System.out.println("������ �̸� �Է�");
		String name=sc.nextLine();
		boolean find=false;//ã���� true �� ����
		for(int i=0;i<list.size();i++)
		{
			Person p=list.get(i);//list ���� i��° person ����Ÿ�� ��´�
			//p �� �̸��� �Է��� �̸��� ������ i��° ����Ÿ�� ����
			if(p.getName().equals(name))
			{
				find=true;
				//����
				list.remove(i);
				break;//�ݺ��� ����������
			}
		}
		if(find)
			System.out.println(name+"���� ����Ÿ�� �����߽��ϴ�");
		else
			System.out.println(name+"���� ��ܿ� �����ϴ�");
	}
	
	public void dataAllWrite()
	{
		System.out.println("\t\tPerson ���");
		System.out.println();
		System.out.println("�̸�\t�⵵\t��\tŰ\t������\t��");
		for(Person p:list)
			System.out.println(p.getName()+"\t"+p.getYear()+"\t"+p.getddi()+"\t"+
					p.getHeight()+"\t"+p.getWeight()+"\t"+p.getPungga());
	}
	
	public int getMenu()
	{
		int menu;
		System.out.println("1.�߰�  2.����  3.��ü���  4.����");
		System.out.println("��ȣ�� �����ϼ���");
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
				System.out.println("** ���α׷��� �����մϴ� **");
				System.exit(0);
			}
			System.out.println();
		}
	}

}









