package day0902;

import java.util.Scanner;

public class Ex25Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���ڸ� �Է��ϸ� 1���� �� ���ڱ����� ���� ���Ͻÿ�
		//��) 100 �� �Է��ϸ�  5050
		Scanner sc=new Scanner(System.in);
		int su,sum=0;
		System.out.println("���� �Է�");
		su=sc.nextInt();
		for(int i=1;i<=su;i++)
		{
			sum+=i;
		}
		System.out.println("1���� "+su+"������ ���� "+sum+" �Դϴ�");
		System.out.println();
		
		//2 3 �� �Է��ϸ� "2��3���� 8�Դϴ�" ��� ���
		//3 3 �� �Է��ϸ� "3��3���� 27�Դϴ�" ��� ���
		int x,y,sum2=1;
		System.out.println("�������� ���� �� ���� �Է�");
		x=sc.nextInt();
		y=sc.nextInt();
		
		for(int i=1;i<=y;i++)
		{
			sum2*=x;
		}
		System.out.printf("%d �� %d ���� %d �Դϴ�",x,y,sum2);
	}

}










