package day0904;

import java.util.Random;
import java.util.Scanner;

public class Ex9Baseball {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int �迭�� �ߺ�ó���� 3���� ���ڸ� ������ �˾Ƹ��߱� ����
		 * �ڸ����� Ʋ���� �� ���� ����. �ڸ������� ������ ��Ʈ����ũ ���� ����
		 * 3 ��Ʈ����ũ�� ���;� �����Դϴ�
		 */
		int []comsu=new int[3];//������ ����
		int []usersu=new int[3];//����ڰ� �Է��ϴ� �� ����
		String number;//3�ڸ��� ���ڸ� ���ڿ� ���·� �Է�
		int strike,ball;
		Scanner sc=new Scanner(System.in);
		Random r=new Random();
		
		//comsu �� 1~9 ������ �ߺ����� ���� ���� ��������
		Loop:
		for(int i=0;i<comsu.length;i++)
		{
			comsu[i]=r.nextInt(9)+1;
			for(int j=0;j<i;j++)
			{
				if(comsu[i]==comsu[j])
				{
					i--;
					continue Loop;
				}
			}
		}
		
		//System.out.printf("com %d %d %d\n",comsu[0],comsu[1],comsu[2]);
		
		while(true)
		{
			strike=ball=0;
			System.out.println("3�ڸ� ���ڸ� �Է��ϼ���(�������)");
			number=sc.nextLine();
			//number�� usersu �� �迭���·� �и��ؼ� �ֱ�
			//���ڷ� �Է½� '1'�� �����δ� 49(�ƽ�Ű�ڵ�ǥ ����)
			usersu[0]=number.charAt(0)-'0';
			usersu[1]=number.charAt(1)-'0';
			usersu[2]=number.charAt(2)-'0';
			//System.out.printf("user %d %d %d\n",usersu[0],usersu[1],usersu[2]);
			
			//comsu �� usersu �� ���Ͽ� ���� ���ڰ� ������ �ڸ��� ����
			//�ڸ������� ������ strike ���� ����, �ڸ����� �ٸ��ٸ� ball���� ����
			//strike ������ 3�� �Ǹ� "�����մϴ�. �����Դϴ�(xxx)" ����
			//���� for��
			for(int i=0;i<comsu.length;i++)
			{
				for(int j=0;j<comsu.length;j++)
				{
					if(usersu[i]==comsu[j])
					{
						if(i==j)
							strike++;
						else
							ball++;
					}
				}
			}
			
			System.out.println(strike+" ��Ʈ����ũ "+ball+" ��");
			if(strike==3)
			{
				System.out.println("�����մϴ�.�����Դϴ�("+comsu[0]+comsu[1]+comsu[2]+")");
				break;
			}
			
		}
		
	}

}



























