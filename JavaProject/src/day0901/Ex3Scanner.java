package day0901;

import java.util.Scanner;

public class Ex3Scanner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Ű����κ��� ���� �Է¹޴´�
		Scanner sc=new Scanner(System.in);
		
		System.out.println("����� �̸��� �Է��ϼ��� 1");
		//�̸��� �Է¹ޱ� ���� ���� ����
		String name=sc.nextLine();//�Է��� ���ʹ����� �ѹ����� �о�´�
		//���
		System.out.println("�� �̸��� "+name+"�Դϴ�");
		
		System.out.println("����� �̸��� �Է��ϼ��� 2");
		//�̸��� �Է¹ޱ� ���� ���� ����
		String name2=sc.next();//�Է��� ���ʹ����� �Ѵܾ �о�´�
		//���
		System.out.println("�� �̸��� "+name2+"�Դϴ�");
	}

}
