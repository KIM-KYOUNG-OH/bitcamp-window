package day0902;

import java.util.Scanner;

public class Ex1Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��� ������ +,-,*,/,%
		//�μ��� �Է����Ŀ� ��������ڷ� ��� ����� ���
		Scanner sc=new Scanner(System.in);
		int su1,su2;
		System.out.println("�μ��� �Է����ּ���");
		su1=sc.nextInt();
		su2=sc.nextInt();
		
		System.out.printf("%20s\n\n","*�����*");
		System.out.printf("%d+%d=%d\n",su1,su2,su1+su2);
		System.out.printf("%d-%d=%d\n",su1,su2,su1-su2);
		System.out.printf("%d*%d=%d\n",su1,su2,su1*su2);
		System.out.printf("%d%%%d=%d\n",su1,su2,su1%su2);
		System.out.printf("%d/%d=%.1f\n",su1,su2,(double)su1/su2);		
	}

}
