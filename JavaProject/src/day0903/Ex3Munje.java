package day0903;

import java.util.Random;
import java.util.Scanner;

public class Ex3Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1~100 ������ ������ ���Ƿ� �߻��� �� ���� �˾Ƹ��߱�
		//��: 67 �̹߻�
		//56 �Է½� : 56���� Ů�ϴ�
		//89 �Է½� : 89���� �۽��ϴ�
		//67 �Է½� : �����Դϴ�(67)-���α׷� ����
		Scanner sc=new Scanner(System.in);
		Random r=new Random();
		//1~100 ������ ���� �߻�
		int ran=r.nextInt(100)+1;
		int su,cnt=0;
		while(true)
		{
			System.out.println("�����Է�("+ ++cnt+")");
			su=sc.nextInt();
			if(su>ran)
				System.out.println(su+"���� �۽��ϴ�");
			else if(su<ran)
				System.out.println(su+"���� Ů�ϴ�");
			else {
				System.out.println("�����Դϴ�("+ran+")");
				break;
			}
			
		}
		System.out.println("** ���� ���� **");
	}
}













