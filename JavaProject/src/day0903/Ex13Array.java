package day0903;

import java.util.Scanner;

public class Ex13Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//10���� ���̸� �Է��� �� ���ɺ� �ο��� ����Ͻÿ�
		//��¿�
		//��ü ����Ÿ�� ����ϰ�
		//10��   : 3��
		//....50����� ���
		//�Է½� 10�� �̸��̰ų� 60�� �̻��̸� �ٽ� �Է�
		Scanner sc=new Scanner(System.in);
		int []person=new int[10];
		int []inwon=new int[5];//�迭�� �ο����� ����(0������ 10���ο���,1������ 20�� �ο���)
		
		//���� �Է�
		for(int i=0;i<person.length;i++)
		{
			System.out.println(i+"���� ����:");
			int n=sc.nextInt();
			if(n<10 || n>=60)
			{
				System.out.println("\t�ٽ� �Է����ּ���(10~59)");
				i--;
				continue;//i++ �� �̵�
			}
			person[i]=n;
			//�ο��� ���
			inwon[n/10-1]++;
		}
		System.out.println("** ��ü ���� ��� **");
		for(int i=0;i<person.length;i++)
			System.out.print(i+":"+person[i]+"  ");
		System.out.println();
		
		System.out.println("** ���ɺ� �ο��� **");
		for(int i=0;i<inwon.length;i++)
		{
			System.out.println((i+1)*10+"��:"+inwon[i]+"��");
		}
	}

}





















