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
	
	//����Ÿ �Է��ϴ� �޼���
	public void dataAdd()
	{
		System.out.println("�ο����� �Է��ϼ���");
		inwon=Integer.parseInt(sc.nextLine());
		//�޸� �Ҵ�
		sa=new Sawon[inwon];
		//�ο�����ŭ ������� �Է��ؼ� �迭�� ����
		for(int i=0;i<inwon;i++)
		{
			System.out.println("����� �Է�");
			String name=sc.nextLine();
			System.out.println("�����Է�");
			int age=Integer.parseInt(sc.nextLine());
			System.out.println("�������Է�");
			String blood=sc.nextLine();
			System.out.println("�޿� �Է�");
			int pay=Integer.parseInt(sc.nextLine());
			System.out.println("�����Է�");
			int sudang=Integer.parseInt(sc.nextLine());
			
			//i��° ��� Ŭ���� �����ϸ鼭 ������
			sa[i]=new Sawon(name, age, blood, pay, sudang);
			System.out.println();			
		}
	}
	
	//����ϴ� �޼���
	public void dataWrite()
	{
		System.out.println("��ȣ\t�̸�\t����\t������\t�޿�\t����\t�ѱݾ�");
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








