package day0901;

import java.util.Scanner;

public class Ex4Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		//���� ����
		int year;
		double su1,su2;
		//�Է�
		System.out.println("�¾ �⵵�� �Է��ϼ���");
		year=sc.nextInt();
		
		System.out.println("�Ǽ�Ÿ���� �μ��ڸ� �Է����ּ���");
		su1=sc.nextDouble();
		su2=sc.nextDouble();
		
		//���
		System.out.println("���� "+year+"����Դϴ�");
		System.out.println("�ΰ����� ���� "+(su1+su2)+" �Դϴ�");
		
	}

}
