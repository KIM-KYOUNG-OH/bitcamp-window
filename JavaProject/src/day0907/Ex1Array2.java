package day0907;

import java.util.Scanner;

public class Ex1Array2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 3��3���� 2���� �迭�� �����Ŀ� 1~3 ������ ������ ���Ƿ� ������
		 * ����,����,�밢������ ���� ���ڰ� ������ �� ������ ���, ������ �� ���		 * 
		 */
		int [][]arr=new int[3][3];
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			//1~3 ������ ���� �߻�
			for(int i=0;i<arr.length;i++)
			{
				for(int j=0;j<arr[i].length;j++)
				{
					arr[i][j]=(int)(Math.random()*3)+1;//1~3���� ���� �߻�
				}
			}
			
			//���
			for(int i=0;i<arr.length;i++)
			{
				for(int j=0;j<arr[i].length;j++)
				{
					System.out.print(arr[i][j]+"\t");
				}
				System.out.println();
			}
			
			//���ι���,���ι���, �밢���� ���Ͽ� ���� ���� ������ binggo ���� 1����
			int binggo=0;
			//����,���ι���
			for(int i=0;i<arr.length;i++)
			{
				if(arr[i][0]==arr[i][1] && arr[i][1]==arr[i][2])//���ι���
					binggo++;
				if(arr[0][i]==arr[1][i] && arr[1][i]==arr[2][i])//���ι���
					binggo++;
			}
			//   / �밢��
			if(arr[0][2]==arr[1][1] && arr[1][1]==arr[2][0])
				binggo++;
			//   \ �밢��
			if(arr[0][0]==arr[1][1] && arr[1][1]==arr[2][2])
				binggo++;
			
			if(binggo>0)
				System.out.println("���� "+binggo+"��");
			else
				System.out.println("��!!!!!!");
			
			//q�� ������ ����
			System.out.println("�����Ϸ��� q �Ǵ� Q �� �����ּ���");
			String ans=sc.nextLine();
			if(ans.equalsIgnoreCase("q"))
			{
				System.out.println("�����մϴ�");
				break;
			}
		}
	}

}
