package day0904;

import java.util.Scanner;

public class Ex4OX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*����� ���Ͽ� ox����ϱ�
		 *  ����  1 4 2 3 1
		 *   ��   1 2 2 4 3
		 *  ä��  O X O X X
		 *    ����  2��
		 */
		Scanner sc=new Scanner(System.in);
		int []jungdap= {1,4,2,3,1};
		int []dap=new int[5];
		char []ox=new char[5];
		int count=0;
		
		//�� �Է�
		System.out.println("�� 5���� �Է����ּ���(4������)");
		for(int i=0;i<dap.length;i++)
		{
			dap[i]=sc.nextInt();
		}
		
		//���� ���
		System.out.print("���� : ");
		for(int j:jungdap)
			System.out.print(j+" ");
		System.out.println();
		System.out.print("  �� : ");
		for(int d:dap)
			System.out.print(d+" ");
		System.out.println();
		
		//ä��
		for(int i=0;i<ox.length;i++)
		{
			if(jungdap[i]==dap[i])
			{
				ox[i]='O';
				count++;//���䰹�� ����
			}else
				ox[i]='X';			
		}
		
		System.out.print("ä�� : ");
		for(char ch:ox)
			System.out.print(ch+" ");
		System.out.println();
		System.out.println("���� : "+count+"��");
	}

}














