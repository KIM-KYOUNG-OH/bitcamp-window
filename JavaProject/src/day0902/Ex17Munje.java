package day0902;

import java.util.Scanner;

public class Ex17Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		//while�� ����
		//����(score) �� �Է��ϴٰ� 0�� �Է��ϸ� �ݺ�����
		//�������� �� ����,����,���(�Ҽ���1�ڸ�) ����ϱ�
		//���� ����
		int score,count=0,sum=0;
		double avg;
		while(true)
		{
			//���� �Է�
			System.out.println("���� �Է�");
			score=sc.nextInt();
			//���������� ����
			if(score==0)
				break;
			//�Է°��� sum �� ���ϱ�
			sum+=score;
			//count ����
			count++;			
		}
		//��ձ��ϱ�
		avg=(double)sum/count;
		//���
		System.out.println("�� ����:"+count);
		System.out.println("�հ�:"+sum);
		System.out.printf("���:%.1f\n",avg);
	}

}




