package day0902;

import java.util.Scanner;

public class Ex6Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����(����) ������
		//���ǽ�?���϶���:�����϶���
		//�μ��� �Է��� �� ū���� max ������ ������ ���
		Scanner sc=new Scanner(System.in);
		int su1,su2,su3,max;
		System.out.println("�μ��� �Է��ϼ���");
		su1=sc.nextInt();
		su2=sc.nextInt();
		
		max=su1>su2?su1:su2;
		System.out.println("max="+max);
		
		//�̹��� 3���ڸ� �Է��� ���� ū���� max�� �����ϱ�
		System.out.println("������ ���� �Է��ϼ���");
		su1=sc.nextInt();
		su2=sc.nextInt();
		su3=sc.nextInt();
		
		max=su1>su2&&su1>su3?su1:su2>su1&&su2>su3?su2:su3;
		System.out.println("max="+max);
		
	}

}







