package day0903;

import java.util.Scanner;

public class Ex11Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []data= {3,7,11,1,6,8,9,15,17,20};
		System.out.println(data.length);
		//while�ݺ��� ���
		//���ڸ� �Է��Ͽ� ���° �ִ��� ����ϱ�
		//������� "�����ϴ�" ���
		//0 �Է��ϸ� "����" ����ϰ� ����
		int su;
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("�˻��� ���ڸ� �Է��ϼ���");
			su=sc.nextInt();
			if(su==0)
			{
				System.out.println("** ���� **");
				break;
			}
			
			boolean find=false;//ã����� true�� ��ȯ
			for(int i=0;i<data.length;i++)
			{
				if(su==data[i])
				{
					find=true;
					System.out.println(i+1+"��°�� �־��!!!");
					break;
				}
			}
			
			//if(find==false)
			if(!find)
				System.out.println(su+" ���� �����ϴ�");
			System.out.println();
		}
		
	}

}

















