package day0902;

import java.util.Scanner;

public class Ex2Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��������� ����
		//�ݾ��� �Է��ϸ� ����:21��,õ��:4��...1��:3�� 
		//��ó�� ��µǵ��� ���α׷��� �ۼ����ּ���
		//��: 764532..����:76��,õ��:4��...1��:2��
		Scanner sc=new Scanner(System.in);
		int money;
		System.out.println("�ݾ��� �Է����ּ���");
		money=sc.nextInt();
		System.out.println("���� :"+money/10000);
		System.out.println("õ�� :"+(money%10000)/1000);
		System.out.println("��� :"+(money%1000)/100);
		System.out.println("�ʿ� :"+(money%100)/10);
		System.out.println("�Ͽ� :"+money%10);		
	}

}
