package day0909;

import java.util.Scanner;

abstract class Board
{
	abstract public void process(); 
}

class InsertBoard extends Board
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("�Խ��ǿ� ����Ÿ�� �߰��Ѵ�");
	}
}

class ListBoard extends Board
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("�Խ��ǿ� ����Ÿ�� ����Ѵ�");
	}
}

class UpdateBoard extends Board
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("�Խ��ǿ� ����Ÿ�� �����Ѵ�");
	}
}

class DeleteBoard extends Board
{
	@Override
	public void process() {
		// TODO Auto-generated method stub
		System.out.println("�Խ��ǿ� ����Ÿ�� �����Ѵ�");
	}
}

public class Ex5InheriMunje {
	public static void process(Board b)
	{
		b.process();//������ó��
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("1. �߰�  2.����  3.����  4.������  5.����");
			System.out.println("�����ϼ���");
			int num=sc.nextInt();
			if(num>4)
			{
				System.out.println("** �����մϴ� **");
				break;
			}
			
			switch(num)
			{
			case 1:
				process(new InsertBoard());
				break;
			case 2:
				process(new DeleteBoard());
				break;
			case 3:
				process(new UpdateBoard());
				break;
			case 4:
				process(new ListBoard());				
			}
		}
	}

}



























