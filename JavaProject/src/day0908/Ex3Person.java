package day0908;

import java.util.Scanner;

public class Ex3Person {
	Person []per;
	Scanner sc;
	int inwon;
	
	public Ex3Person() {
		// TODO Auto-generated constructor stub
		System.out.println("������");
		sc=new Scanner(System.in);
	}
	public void dataAdd()
	{
		//�ο����� �Է��� �ο�����ŭ ����Ÿ �Է�
		System.out.println("�ο���");
		inwon=Integer.parseInt(sc.nextLine());
		//�迭 �Ҵ�
		per=new Person[inwon];
		for(int i=0;i<inwon;i++)
		{
			per[i]=new Person();
			
			System.out.println("�̸�");
			String name=sc.nextLine();
			per[i].setName(name);
			
			System.out.println("�¾ �⵵");
			int year=Integer.parseInt(sc.nextLine());
			per[i].setYear(year);
			
			System.out.println("Ű");
			double height=Double.parseDouble(sc.nextLine());
			per[i].setHeight(height);
			
			System.out.println("������");
			double weight=Double.parseDouble(sc.nextLine());
			per[i].setWeight(weight);		
			
		}
	}
	
	public void dataWrite()
	{
		//���
		//��ȣ,�̸�,�¾�⵵,��,Ű,������,��
		System.out.println("��ȣ\t�̸�\t�⵵\t��\tŰ\t������\t��");
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

