package day0901;

import java.util.Scanner;

public class Ex12Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�̸��� ����,����,���� ������ �Է¹޾�
		//�̸�,����,����� ����ϴµ� ����� �Ҽ������� 2�ڸ������� ���
		//��� printf �� ����ؼ� ����ϼ���
		Scanner sc=new Scanner(System.in);
		//���� ����
		String name;
		int kor,eng,mat;
		int tot;
		double avg;
		
		//�Է�
		System.out.println("Input name?");
		name=sc.nextLine();
		System.out.println("Input Kor score?");
		kor=sc.nextInt();
		System.out.println("Input Eng score?");
		eng=sc.nextInt();
		System.out.println("Input Mat score?");
		mat=sc.nextInt();
		
		//����
		tot=kor+eng+mat;
		avg=(double)tot/3;
		
		//���
		System.out.printf("�̸� : %s\n",name);
		System.out.printf("���� : %d\n",tot);
		System.out.printf("��� : %5.2f\n",avg);
	}

}
