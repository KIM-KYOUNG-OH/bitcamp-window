package day0902;

import java.util.Scanner;

public class Ex11Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		//1~12 ���� �Է��� ���ϱ��� �ִ��� ���
		//1~12�� �ƴϸ� "�߸��Է��߾��"
		
		//{} �ȿ��� �����ϴ� ���������� �ڵ��ʱ�ȭ�� �ȵǰ� �� �ȿ��� �����Ⱚ�� ���վ
		//�ݵ�� ���� ���־�� ������ �ȳ���.
		int month,days=0;
		System.out.println("1~12 ���� ���� �Է����ּ���");
		month=sc.nextInt();
		switch(month)
		{
		case 4: case 6: case 9: case 11:
			days=30;
			break;
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			days=31;
			break;
		case 2:
			days=28;
			break;
		default:
			System.out.println("�߸��Է��߾��");
		}
		if(days>0)
			System.out.println(month+" ���� "+days+"���� �־��!!");
	}

}





