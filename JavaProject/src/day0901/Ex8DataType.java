package day0901;

import java.util.Scanner;

public class Ex8DataType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String sang;
		int su,dan;
		
		System.out.println("��ǰ�� �Է�");
		sang=sc.nextLine();
		
		System.out.println("���� �Է�");
		su=sc.nextInt();
		
		System.out.println("�ܰ� �Է�");
		dan=sc.nextInt();
		
		//printf�� �̿��ؼ� ��ü�� ����غ���
		System.out.printf("%30s\n\n","**���Ի�ǰ**");//��������
		System.out.printf("%-30s\n\n","**���Ի�ǰ**");//��������
		System.out.printf("��ǰ�� : %s\n",sang);
		System.out.printf("���� : %d\n",su);
		System.out.printf("�ܰ� : %d\n",dan);
		System.out.printf("�ѱݾ� : %d\n",su*dan);		
	}

}








