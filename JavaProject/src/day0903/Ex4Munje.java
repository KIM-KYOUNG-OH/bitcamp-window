package day0903;

import java.util.Random;
import java.util.Scanner;

public class Ex4Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1~100 ������ ������ ���Ƿ� �߻��� �� ���� �˾Ƹ��߱�
		//��: 67 �̹߻�
		//56 �Է½� : 56���� Ů�ϴ�
		//89 �Է½� : 89���� �۽��ϴ�
		//67 �Է½� : �����Դϴ�(67)-���(y or n)? y ������ ���ο� ����-�Լ� �˾Ƹ��߱�
		//y �� �ƴҰ�� "** �������� **" ����� ����
		
		Scanner sc=new Scanner(System.in);
		Random r=new Random();
		Exit:
		while(true)
		{
			System.out.println("���ο� ������ �߻��մϴ�");
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
					System.out.println("����Ϸ��� y ��,�׸��Ϸ��� n�� �����ּ���");
					//������ ���� �о �����ϱ�
					sc.nextLine();
					char ans=sc.nextLine().charAt(0);
					//if(!(ans=='y'||ans=='Y'))
					if(ans!='y' && ans!='Y')	
						break Exit;//�ܺ� while���� ����������
					else
						continue Exit;//�ٱ��� �ݺ����� ���ǽ����� �̵�
				}				
			}
		}
		
		System.out.println("** ���� ���� **");
	}

}













