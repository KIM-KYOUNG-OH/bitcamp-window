package day0902;

import java.util.Scanner;

public class Ex7Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		//������ �Է��� ������ ���Ͻÿ�
		//90�̻��̸� 'A',80�̻��̸� 'b',...60 �̸��� 'F'
		//����� (��) 78 ���� C�����Դϴ�
		int score;
		char grade;
		System.out.println("������ �Է����ּ���");
		score=sc.nextInt();
		grade=score>=90?'A':score>=80?'B':score>=70?'C':
			score>=60?'D':'F';
		System.out.printf("%d ���� %c �����Դϴ�\n",score,grade);	
		//80�̻��̸� "���",70 �̻��̸� "�����",�� �������� "Ż��"
		System.out.println("����� "+(score>=80?"���":score>=70?"�����":"Ż��"));
	}

}
