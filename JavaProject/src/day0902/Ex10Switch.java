package day0902;

import java.util.Scanner;

public class Ex10Switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���� �ѱ��ڸ� �Է��� ��ҹ��� ������� a�� �Է��ϸ�
		//'Apple' , b�� �Է��ϸ� 'Banana', o�� �Է��ϸ� 'Orange' ���
		//�� �ܴ̿� '���� �����'
		Scanner sc=new Scanner(System.in);
		char alpha;
		System.out.println("���ĺ� �ѱ��� �Է�");
		alpha=sc.nextLine().charAt(0);//�Է��� ���ڿ��� ù���ڸ� �����´�
		System.out.printf("�Է��� ���ĺ��� %c �Դϴ�\n",alpha);
		switch(alpha)//switch���� case���� ���� ����Ÿ��(char����)�� �ü��־��µ�
		//JDK8 ���ʹ� ���ڿ��� ����������
		{
		case 'a':
		case 'A':
			System.out.println("Apple");
			break;
		case 'b':
		case 'B':
			System.out.println("Banana");
			break;
		case 'o': case 'O':
			System.out.println("Orange");
			break;
		default:
			System.out.println("���� �����");		
		}
	}
}







