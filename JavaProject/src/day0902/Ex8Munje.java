package day0902;

import java.util.Scanner;

public class Ex8Munje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�̸��� kor,eng,mat 3������ ������ �Է��Ͽ�
		//����� 60 �̻��̰� �� ������ 40���̻��̸�
		//ȫ�浿���� �ڰ����� ����Ͽ����ϴ�
		//�׷��� ������
		//ȫ�浿���� �ڰ��� ��濡 �����Ͽ����ϴ�
		Scanner sc=new Scanner(System.in);
		String name;
		int kor,eng,mat;
		double avg;
		System.out.println("�̸��Է�");
		name=sc.nextLine();
		System.out.println("3������ ���� �Է�");
		kor=sc.nextInt();
		eng=sc.nextInt();
		mat=sc.nextInt();
		//���
		avg=(kor+eng+mat)/3.0;
		System.out.printf("���:%.1f\n",avg);
		
		System.out.println(name+" ���� "+
				(avg>=60&&kor>=40&&eng>=40&&mat>=40?"�ڰ����� ����Ͽ����ϴ�":
					"�ڰ��� ��濡 �����Ͽ����ϴ�"));
	}

}





