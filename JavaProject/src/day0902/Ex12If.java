package day0902;

import java.util.Scanner;

public class Ex12If {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���� ����
		//�⵵%4==0 && �⵵%100!=0 || �⵵%400==0 �̸� ����
		Scanner sc=new Scanner(System.in);
		int year;
		System.out.println("�⵵�� �Է����ּ���");
		year=sc.nextInt();
		
		if(year%4==0&&year%100!=0||year%400==0)
			System.out.println(year+"�⵵�� �����Դϴ�");
		else
			System.out.println(year+"�⵵�� ����Դϴ�");
	}

}
